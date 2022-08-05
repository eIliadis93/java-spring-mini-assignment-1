package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.DebitCard;
import com.acmeflix.domain.Profile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@AllArgsConstructor
@Slf4j
public class AccountRepositoryImpl extends BaseRepositoryImpl<Account> implements AccountRepository {


    @Autowired
    @Qualifier("profileRepositoryImpl")
    private final ProfileRepository profileRepository;
    private final Map<Long, Account> data = new LinkedHashMap<>();

    private final AtomicLong atomicLong = new AtomicLong(1);


    @Override
    public Map<Long, Account> getStorage() {
        return this.data;
    }

    @Override
    public AtomicLong getSequence() {
        return this.atomicLong;
    }

    public List<Account> findAccountByEmail(String email) {
        return this.data.values().stream().filter(tmp -> tmp.getEmail().equalsIgnoreCase(email)).toList();
    }

    public void updateProfile(Account account, Profile profile) {
        if (account.getProfiles().contains(profile)) {
            profileRepository.update(profile);
        } else {
            new IllegalArgumentException("This profile does not exist on the account");
        }
    }

    @Override
    public void deleteProfile(Account account, Profile profile) {
        profileRepository.delete(profile);
    }


    @Override
    public boolean availableSubscription(Account account) {
        if (account.isSubscription()) {
            logger.info("Account {} have an active subscription.", account.getId());
            return true;
        } else {
            logger.info("Account {} subscription is over, subscription payment sequence initializing.", account.getId());
            subscriptionPayment(account);
            return false;
        }
    }

    @Override
    public void subscriptionPayment(Account account) {
        if (!account.isSubscription()) {
            if (account.getDebitCard().isEmpty()) {
                logger.info("There is not a saved payment method for the account {}, please add a payment method.", account.getId());
                addDebitCard(account);
            }
            account.getDebitCard();
            account.getSubscriptionPlan();
            account.setSubscription(true);
        } else {
            logger.info("This account already have an active subscription.");
        }
    }

    @Override
    public void addProfile(Account account, Profile profile) {
        availableSubscription(account);
        profileRepository.create(profile);
    }

    @Override
    public void addDebitCard(Account account) {
        DebitCard debitCard = DebitCard.builder().build();
        if (account.getDebitCard().contains(debitCard)) {
            new IllegalArgumentException("The follow debit card already exist on the account.");
        }
        account.getDebitCard().add(debitCard);
        logger.info("Debit Card {} added as a viable payment method.", debitCard.getCardNumber());
    }

}
