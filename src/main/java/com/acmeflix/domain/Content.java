package com.acmeflix.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Content extends BaseModel {

    private String title;
    private int rating;
    private String plot;
    private List<Language> language;
    private List<Language> subtitles;
    private List<Genre> genres;
    private MaturityRating maturityRating;
    private Restrictions restrictions;
    private List<Content> recommendations;

}
