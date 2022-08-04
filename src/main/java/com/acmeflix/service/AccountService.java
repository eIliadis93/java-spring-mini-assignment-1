package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Content;
import com.acmeflix.domain.Profile;

public interface AccountService extends BaseService<Account, Long> {

    void addProfile(Account account, Profile profile);

    void updateProfile(Account account, Profile profile);

    void deleteProfile(Account account, Profile profile);

    void subscriptionPayment(Account account);

    boolean availableSubscription(Account account);

    Account findAccountByEmail(String email);

    void addProfileContent(Content content, Profile profile);

}
