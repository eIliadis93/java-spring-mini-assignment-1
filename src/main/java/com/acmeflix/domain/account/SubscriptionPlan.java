package com.acmeflix.domain.account;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum SubscriptionPlan {

    Starter(new BigDecimal("7.99")),
    Standard(new BigDecimal("10.99")),
    Full(new BigDecimal("13.99"));

    private final BigDecimal paymentAmount;

    SubscriptionPlan(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
