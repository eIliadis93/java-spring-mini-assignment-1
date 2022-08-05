package com.acmeflix.service;

import com.acmeflix.domain.Profile;


public interface ProfileService extends BaseService<Profile, Long> {

    Profile findProfileByName(String name);
}
