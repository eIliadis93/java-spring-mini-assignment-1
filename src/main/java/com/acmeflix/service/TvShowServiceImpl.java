package com.acmeflix.service;

import com.acmeflix.domain.Genre;
import com.acmeflix.domain.TvShow;
import com.acmeflix.repository.BaseRepository;
import com.acmeflix.repository.TvShowRepository;

public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService {
    private final TvShowRepository tvShowRepository;

    public TvShowServiceImpl(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    @Override
    public BaseRepository<TvShow, Long> getRepository() {
        return null;
    }

    @Override
    public TvShow findTvShowByTitle(String str) {
        return null;
    }
}
