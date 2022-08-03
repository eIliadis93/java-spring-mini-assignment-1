package com.example.javaspringminiassignment1.domain.program.Crew;

import com.example.javaspringminiassignment1.domain.BaseModel;
import lombok.*;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Crew extends BaseModel {

    private String firstName;
    private String lastName;
    private String profession;

}
