package com.acmeflix.domain.contentCatalog.tvShow;

import com.acmeflix.domain.BaseModel;
import com.acmeflix.domain.contentCatalog.Cast.Actor;
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
    private List<Actor> actors;
    private int durationInMinutes;
}
