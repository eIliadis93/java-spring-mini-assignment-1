package com.acmeflix.domain.program.tvShow;

import com.acmeflix.domain.BaseModel;
import com.acmeflix.domain.program.Crew.Actor;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Episode extends BaseModel {

    private String episodeTitle;
    private BigDecimal length;
    private List<Actor> actors;
}
