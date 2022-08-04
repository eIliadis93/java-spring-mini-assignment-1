package com.acmeflix.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Season extends BaseModel {

    private String seasonTitle;
    private List<Episode> episodes;
    private Director director;

}
