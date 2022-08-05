package com.acmeflix.repository;

import com.acmeflix.domain.TvShow;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TvShowRepositoryImpl extends BaseRepositoryImpl<TvShow> implements TvShowRepository {

    private final Map<Long, TvShow> data = new LinkedHashMap<>();
    private final AtomicLong atomicLong = new AtomicLong(1);

    @Override
    public Map<Long, TvShow> getStorage() {
        return this.data;
    }

    @Override
    public AtomicLong getSequence() {
        return this.atomicLong;
    }

    @Override
    public List<TvShow> findTvShowByTitle(String str) {
        return this.data.values().stream().filter(shows -> shows.getTitle().equalsIgnoreCase(str)).toList();
    }
}
