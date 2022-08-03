package com.acmeflix.domain.program.tvShow;

import com.acmeflix.domain.program.Program;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TvShow extends Program {

    private List<Season> seasons;
}
