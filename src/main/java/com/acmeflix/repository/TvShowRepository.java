package com.acmeflix.repository;

import com.acmeflix.domain.Movie;
import com.acmeflix.domain.TvShow;

import java.util.List;

public interface TvShowRepository extends  BaseRepository<TvShow, Long> {
    List<TvShow> findTvShowByTitle(String str);
}
