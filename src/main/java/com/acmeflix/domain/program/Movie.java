package com.acmeflix.domain.program;

import com.acmeflix.domain.program.Crew.Actor;
import com.acmeflix.domain.program.Crew.Director;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends Program {

    private Director director;
    private List<Actor> actors;
}
