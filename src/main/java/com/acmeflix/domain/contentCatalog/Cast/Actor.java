package com.acmeflix.domain.contentCatalog.Cast;

import com.acmeflix.domain.BaseModel;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Actor extends BaseModel {

    private String firstName;
    private String lastName;
    private LocalDate dob;

}
