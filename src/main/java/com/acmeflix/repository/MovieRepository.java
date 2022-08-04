package com.acmeflix.repository;

import com.acmeflix.domain.Movie;

import java.util.List;

public interface MovieRepository extends BaseRepository<Movie, Long> {
    List<Movie> findMovieByTitle(String str);
}
