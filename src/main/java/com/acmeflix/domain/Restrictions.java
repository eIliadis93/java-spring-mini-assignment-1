package com.acmeflix.domain;

public enum Restrictions {
    SEVEN(7), THIRTEEN(13), SIXTEEN(16), EIGHTEEN(18), ALL(1000);
    private final Integer age;

    Restrictions(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return this.age;
    }

}
