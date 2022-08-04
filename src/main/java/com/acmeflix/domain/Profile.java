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
public class Profile extends BaseModel {
    private Restrictions restrictions;
    private String name;
    private Language language;
    private boolean rate;
    private List<Content> contents;
    private Account account;
}
