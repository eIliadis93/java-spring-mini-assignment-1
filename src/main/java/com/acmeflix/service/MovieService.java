package com.acmeflix.service;

import com.acmeflix.domain.contentCatalog.Movie;

public interface MovieService extends BaseService<Movie,Long> {
    Movie findMovieByTitle(String str);
}
