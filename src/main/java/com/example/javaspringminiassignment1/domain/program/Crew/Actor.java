package com.example.javaspringminiassignment1.domain.program.Crew;

import com.example.javaspringminiassignment1.domain.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class Actor extends BaseModel {

    private String firstName;
    private String lastName;
    private LocalDate dob;

}
