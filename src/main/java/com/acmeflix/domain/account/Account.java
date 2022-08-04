package com.acmeflix.domain.account;


import com.acmeflix.domain.BaseModel;
import com.acmeflix.domain.Profile;
import com.acmeflix.domain.contentCatalog.Content;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class Account extends BaseModel {

    private String email;
    private String phoneNumber;
    private String country;
    private DebitCard debitCard;
    private List<Profile> profiles;
    private List<Content> programWatched;
    private boolean subscription;
    private SubscriptionPlan subscriptionPlan;

}
