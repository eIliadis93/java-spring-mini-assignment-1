package com.acmeflix.domain.contentCatalog.tvShow;

import com.acmeflix.domain.BaseModel;
import com.acmeflix.domain.contentCatalog.Cast.Director;
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
