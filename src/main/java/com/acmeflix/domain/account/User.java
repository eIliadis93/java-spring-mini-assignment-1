package com.acmeflix.domain.account;

import com.acmeflix.domain.program.Program;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@Builder
public class User {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int age;

    private List<Program> programWatched;

    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
