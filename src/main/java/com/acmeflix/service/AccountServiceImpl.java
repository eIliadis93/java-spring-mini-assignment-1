package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Content;
import com.acmeflix.domain.Profile;
import com.acmeflix.repository.AccountRepository;
import com.acmeflix.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public BaseRepository<Account, Long> getRepository() {
        return accountRepository;
    }


    @Override
    public void addProfile(Account account, Profile profile) {
        availableSubscription(account);
        account.getProfiles().add(profile);
        logger.info("The profile {} has been added successfully.", profile.getName());
    }

    @Override
    public void updateProfile(Account account, Profile profile) {
        availableSubscription(account);
        if (profile.getAccount() == account) {
            logger.info("Updating selected Profile.");
            accountRepository.updateProfile(account, profile);
        } else {
            logger.info("This profile {} does not exist on the account {}."
                    , profile.getName(), account.getId());
        }
    }

    @Override
    public void deleteProfile(Account account, Profile profile) {
        if (profile.getAccount() == account) {
            logger.info("Deleting selected Profile.");
            accountRepository.deleteProfile(account, profile);
        } else {
            logger.info("This profile {} does not exist on the account {}."
                    , profile.getName(), account.getId());
        }
    }

    @Override
    public void subscriptionPayment(Account account) {
        if (!account.isSubscription()) {
            account.getDebitCard();
            account.getSubscriptionPlan();
            account.setSubscription(true);
        } else {
            logger.info("This account already have an active subscription.");
        }
    }

    @Override
    public boolean availableSubscription(Account account) {
        logger.info("Checking if there is any active subscription for the account {}.", account.getId());
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
    public Account findAccountByEmail(String email) {
        List<Account> accounts = accountRepository.findAccountByEmail(email);
        if (accountRepository.findAccountByEmail(email).isEmpty()) {
            logger.info("No account registered with email {} exist.", email);
        }
        logger.info("Account with email {} , found", email);
        return accounts.get(0);
    }

    @Override
    public void addProfileContent(Content content, Profile profile) {
        if (!profile.getAccount().isSubscription()) {
            throw new IllegalArgumentException("You cannot watch any content without a subscription");
        } else {
            accountRepository.addProfileContent(content, profile);
            logger.info("Content list had been updated.");
        }
    }

}
