package com.acmeflix.repository;

import com.acmeflix.domain.Account;

import java.util.List;

public interface AccountRepository extends BaseRepository<Account, Long> {

    List<Account> findAccountByEmail(String email);
}
