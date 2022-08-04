package com.acmeflix.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TvShow extends Content {

    private List<Season> seasons;
}
