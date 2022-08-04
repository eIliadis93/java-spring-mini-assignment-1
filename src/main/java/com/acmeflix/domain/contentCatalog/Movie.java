package com.acmeflix.domain.contentCatalog;

import com.acmeflix.domain.contentCatalog.Cast.Actor;
import com.acmeflix.domain.contentCatalog.Cast.Director;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends Content {

    private Director director;
    private List<Actor> actors;
    private int durationInMinutes;
    private boolean watched;
}
