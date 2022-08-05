package com.acmeflix.repository;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.Content;
import com.acmeflix.domain.Profile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository("accountRepo")
public class AccountRepositoryImpl extends BaseRepositoryImpl<Account> implements AccountRepository {
    protected Logger logger = LoggerFactory.getLogger(getClass());
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
        profile.getName();
        profile.getLanguage();
        profile.getContents();
        profile.getRestrictions();
    }

    @Override
    public void deleteProfile(Account account, Profile profile) {
        account.getProfiles().remove(profile);
    }

    @Override
    public void addProfileContent(Content content, Profile profile) {
        if (profile.getContents().contains(content)) {
            logger.info("Content is already on the list.");
        } else {
            profile.getContents().add(content);
        }
    }

}
