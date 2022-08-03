package com.example.javaspringminiassignment1.domain.program;

import com.example.javaspringminiassignment1.domain.program.Crew.Actor;
import com.example.javaspringminiassignment1.domain.program.Crew.Crew;
import com.example.javaspringminiassignment1.domain.program.Crew.Director;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class Movie extends Program {

    private Director director;
    private List<Actor> actors;
    private List<Crew> crew;
}
