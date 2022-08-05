package com.acmeflix.repository;

import com.acmeflix.domain.Profile;

import java.util.List;


public interface ProfileRepository extends BaseRepository<Profile, Long> {

    List<Profile> findProfileByName(String name);
}
