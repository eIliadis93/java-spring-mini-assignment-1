package com.example.javaspringminiassignment1.domain.program.tvShow;

import com.example.javaspringminiassignment1.domain.program.Crew.Actor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Episode {

    private String episodeTitle;
    private BigDecimal length;
    private List<Actor> actors;
}
