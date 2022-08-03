package com.example.javaspringminiassignment1.domain.program.tvShow;

import com.example.javaspringminiassignment1.domain.BaseModel;
import com.example.javaspringminiassignment1.domain.program.Crew.Director;
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
