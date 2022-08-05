package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Profile;
import com.acmeflix.repository.AccountRepository;
import com.acmeflix.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

    @Autowired
    @Qualifier("accountRepositoryImpl")
    private final AccountRepository accountRepository;


    @Override
    public void addProfile(Account account, Profile profile) {
        logger.info("Now creating new profile!");
        accountRepository.addProfile(account, profile);
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
        logger.info("Starting subscription payment procedure.");
        accountRepository.subscriptionPayment(account);
    }

    @Override
    public boolean availableSubscription(Account account) {
        logger.info("Checking if there is any active subscription for the account {}.", account.getId());
        return accountRepository.availableSubscription(account);
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
    public void addDebitCard(Account account) {
        logger.info("A new Debit Card will be added on the account {}.", account.getId());
        accountRepository.addDebitCard(account);
    }

    @Override
    public BaseRepository<Account, Long> getRepository() {
        return this.accountRepository;
    }
}
