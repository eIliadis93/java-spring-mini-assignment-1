package com.acmeflix.service;

import com.acmeflix.domain.Account;
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
    public Account findAccountByEmail(String email) {
        List<Account> accounts = accountRepository.findAccountByEmail(email);
        if (accountRepository.findAccountByEmail(email).isEmpty()) {
            logger.info("No account registered with email {} exist.", email);
        }
        logger.info("Account with email {} , found", email);
        return accounts.get(0);
    }

}
