package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Profile;

import java.util.List;

public interface AccountRepository extends BaseRepository<Account, Long> {

    List<Account> findAccountByEmail(String email);

    void updateProfile(Account account, Profile profile);

    void deleteProfile(Account account, Profile profile);

    boolean availableSubscription(Account account);

    void subscriptionPayment(Account account);

    void addProfile(Account account, Profile profile);

    void addDebitCard(Account account);
}
