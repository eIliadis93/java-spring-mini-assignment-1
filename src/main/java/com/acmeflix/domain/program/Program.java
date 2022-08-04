package com.acmeflix.domain.program;

import com.acmeflix.domain.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Program extends BaseModel {

    private String title;
    private int rating;
    private List<LanguageType> language;
    private List<LanguageType> subtitles;
    private List<Genre> genres;
    private AgeRating ageRating;
    private Restrictions restrictions;
    private List<Program> recommendations;

}
