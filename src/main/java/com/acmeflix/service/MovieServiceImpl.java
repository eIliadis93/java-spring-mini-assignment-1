package com.acmeflix.service;

import com.acmeflix.domain.Movie;
import com.acmeflix.repository.BaseRepository;
import com.acmeflix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl extends BaseServiceImpl<Movie> implements MovieService {
    private final MovieRepository movieRepository;

    @Override

    public BaseRepository<Movie, Long> getRepository() {
        return this.movieRepository;
    }

    @Override
    public Movie findMovieByTitle(String str) {
        List<Movie> movies = movieRepository.findMovieByTitle(str);
        if (movies.size() > 1)
            logger.trace("Number of movies found with title {} is :{}", str, movies.size());
        return movies.get(0);
    }
}
