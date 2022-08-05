package com.acmeflix.bootstrap;

import com.acmeflix.BaseComponent;
import com.acmeflix.domain.*;
import com.acmeflix.service.AccountService;
import com.acmeflix.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@ComponentScan
@RequiredArgsConstructor
@Slf4j
public class SampleAccountCreator extends BaseComponent implements CommandLineRunner {

    @Autowired
    @Qualifier("accountServiceImpl")
    private final AccountService accountService;

    @Autowired
    @Qualifier("profileServiceImpl")
    private final ProfileService profileService;

    @Override
    public void run(String... args) throws Exception {

        List<Account> accounts = List.of(
                Account.builder().email("e.iliadis@pmmretail.com").phoneNumber("6965616168").country("United Kingdom").subscriptionPlan(SubscriptionPlan.Starter).build(),
                Account.builder().email("e.vrailas@pmmretail.com").phoneNumber("6998561212").country("USA").subscriptionPlan(SubscriptionPlan.Standard).build(),
                Account.builder().email("s.christodoulou@pmmretail.com").phoneNumber("6979863186").country("Greece").subscriptionPlan(SubscriptionPlan.Full).build()
        );
        logger.info("Created {} accounts.", accountService.createAll(accounts).size());

        List<Profile> profiles = List.of(
                Profile.builder().restrictions(Restrictions.ALL).name("Vagelis").language(Language.UNITED_KINGDOM).build(),
                Profile.builder().restrictions(Restrictions.ALL).name("Evangelos").language(Language.UNITED_STATES_OF_AMERICA).build(),
                Profile.builder().restrictions(Restrictions.ALL).name("Spiros").language(Language.GREECE).build()
        );
        logger.info("Created {} profiles.", profileService.createAll(profiles).size());


        accountService.findAll().forEach(a -> logger.info("{}", a));

        logger.info("Searching for account {}.", (accountService.findAccountByEmail("e.iliadis@pmmretail.com") != null));
        logger.info("Searching for account {}.", (accountService.findAccountByEmail("e.vrailas@pmmretail.com") != null));
        logger.info("Searching for account {}.", (accountService.findAccountByEmail("s.christodoulou@pmmretail.com") != null));

        Account account1 = accountService.findAccountByEmail("e.iliadis@pmmretail.com");
        Account account2 = accountService.findAccountByEmail("e.vrailas@pmmretail.com");
        Account account3 = accountService.findAccountByEmail("s.christodoulou@pmmretail.com");

        accountService.addProfile(account1, profileService.findProfileByName("Vagelis"));
        accountService.addProfile(account1, profileService.findProfileByName("Evangelos"));
        accountService.addProfile(account1, profileService.findProfileByName("Spiros"));

        logger.info("Profile {} added to {}", profileService.findProfileByName("Vagelis"), accountService.findAccountByEmail("e.iliadis@pmmretail.com"));
        logger.info("Profile {} added to {}", profileService.findProfileByName("Evangelos"), accountService.findAccountByEmail("e.vrailas@pmmretail.com"));
        logger.info("Profile {} added to {}", profileService.findProfileByName("Spiros"), accountService.findAccountByEmail("s.christodoulou@pmmretail.com"));
    }
}
