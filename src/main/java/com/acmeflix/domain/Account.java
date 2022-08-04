package com.acmeflix.domain;


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
    private boolean subscription;
    private SubscriptionPlan subscriptionPlan;

}
