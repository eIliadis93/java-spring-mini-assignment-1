package com.acmeflix.domain.account;


import com.acmeflix.domain.BaseModel;
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
    private String creditCardNumber;
    private List<User> users;
    private boolean subscription;
    private SubscriptionPlan subscriptionPlan;

}
