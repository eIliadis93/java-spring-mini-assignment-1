package com.acmeflix.service;

import com.acmeflix.domain.*;
import com.acmeflix.repository.BaseRepository;
import com.acmeflix.repository.TvShowRepository;

import java.util.Arrays;
import java.util.List;

public class TvShowServiceImpl extends BaseServiceImpl<TvShow> implements TvShowService {
    private final TvShowRepository tvShowRepository;

    public TvShowServiceImpl(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    @Override
    public BaseRepository<TvShow, Long> getRepository() {
        return this.tvShowRepository;
    }

    public void addEpisodes(final Season season, final Episode... episode){
        Arrays.stream(episode).forEach(episodes -> season.getEpisodes().add(episodes));
    }
    public void addSeasons(final TvShow tvShow, final Season... season){
        Arrays.stream(season).forEach(seas -> tvShow.getSeasons().add(seas));

    }
    @Override
    public TvShow findTvShowByTitle(String str) {
        List<TvShow> tvShows = tvShowRepository.findTvShowByTitle(str);
        if (tvShows.size() > 1)
            logger.trace("Number of Tv's Shows found with title {} is :{}", str, tvShows.size());
        return tvShows.get(0);


    }
}
