package com.acmeflix.repository;

import com.acmeflix.domain.Movie;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class MovieRepositoryImpl extends BaseRepositoryImpl<Movie> implements MovieRepository {
    private final Map<Long, Movie> data = new LinkedHashMap<>();
    private final AtomicLong atomicLong = new AtomicLong(1);

    @Override
    public Map<Long, Movie> getStorage() {
        return this.data;
    }

    @Override
    public AtomicLong getSequence() {
        return this.atomicLong;
    }

    @Override
    public List<Movie> findMovieByTitle(String str) {
        return this.data.values().stream().filter(tmp -> tmp.getTitle().equalsIgnoreCase(str)).toList();
    }
}
