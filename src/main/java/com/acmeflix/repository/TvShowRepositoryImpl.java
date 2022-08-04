package com.acmeflix.repository;

import com.acmeflix.domain.TvShow;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class TvShowRepositoryImpl extends BaseRepositoryImpl<TvShow> implements TvShowRepository{
    @Override
    public Map<Long, TvShow> getStorage() {
        return null;
    }

    @Override
    public AtomicLong getSequence() {
        return null;
    }

    @Override
    public List<TvShow> findTvShowByTitle(String str) {
        return null;
    }
}
