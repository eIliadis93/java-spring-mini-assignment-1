package com.acmeflix.repository;

import com.acmeflix.domain.contentCatalog.Movie;
import com.acmeflix.domain.contentCatalog.Movie;

import java.util.List;

public interface MovieRepository extends BaseRepository<Movie,Long>{
    List<Movie> findMovieByTitle(String str);
}
