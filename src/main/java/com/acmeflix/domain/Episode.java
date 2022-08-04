package com.acmeflix.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Episode extends BaseModel {

    private String episodeTitle;
    private List<Actor> actors;
    private int durationInMinutes;
}
