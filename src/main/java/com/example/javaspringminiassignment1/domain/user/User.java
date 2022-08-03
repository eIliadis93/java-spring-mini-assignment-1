package com.example.javaspringminiassignment1.domain.user;

import com.example.javaspringminiassignment1.domain.BaseModel;
import com.example.javaspringminiassignment1.domain.program.Program;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class User extends BaseModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String country;
    private LocalDate dateOfBirth;
    private int age;
    private boolean subscription;
    private SubscriptionPlan subscriptionPlan;
    private List<Program> programWatched;

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
