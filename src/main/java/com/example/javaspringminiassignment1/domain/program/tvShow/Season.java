package com.example.javaspringminiassignment1.domain.program.tvShow;

import com.example.javaspringminiassignment1.domain.program.Crew.Crew;
import com.example.javaspringminiassignment1.domain.program.Crew.Director;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Season {

    private String seasonTitle;
    private List<Episode> episodes;
    private Director director;
    private List<Crew> crew;
}
