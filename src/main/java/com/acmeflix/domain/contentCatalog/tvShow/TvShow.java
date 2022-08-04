package com.acmeflix.domain.contentCatalog.tvShow;

import com.acmeflix.domain.contentCatalog.Content;
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
