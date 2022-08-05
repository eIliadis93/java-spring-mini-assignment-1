package com.acmeflix.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class DebitCard extends BaseModel {
    private String cardNumber;
    private Integer securityCode;
    private String cardHolderName;
    private String expirationDate;

}
