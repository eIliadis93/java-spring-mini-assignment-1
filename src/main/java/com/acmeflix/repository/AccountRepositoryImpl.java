package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository("accountRepo")
public class AccountRepositoryImpl extends BaseRepositoryImpl<Account> implements AccountRepository {

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


}
