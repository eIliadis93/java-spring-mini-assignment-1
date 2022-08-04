package com.acmeflix.domain;

import java.util.List;

public class Profile extends BaseModel {
    private Restrictions restrictions;
    private String name;
    private Language language;
    private boolean rate;
    private List<Content> contents;
    private Account account;
}
