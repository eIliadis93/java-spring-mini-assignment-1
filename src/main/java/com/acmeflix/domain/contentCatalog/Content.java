package com.acmeflix.domain.contentCatalog;

import com.acmeflix.domain.BaseModel;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.DateTimeException;
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
