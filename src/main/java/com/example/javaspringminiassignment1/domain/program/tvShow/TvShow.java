package com.example.javaspringminiassignment1.domain.program.tvShow;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class TvShow {

    private List<Season> seasons;
}
