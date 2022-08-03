package com.example.javaspringminiassignment1.domain.program.tvShow;

import com.example.javaspringminiassignment1.domain.program.Program;
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
