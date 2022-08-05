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
public class Movie extends Content {

    private Director director;
    private List<Actor> actors;
    private int durationInMinutes;
    private boolean watched;
}
