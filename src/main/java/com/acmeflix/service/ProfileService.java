package com.acmeflix.service;

import com.acmeflix.domain.Content;
import com.acmeflix.domain.Profile;


public interface ProfileService extends BaseService<Profile, Long> {

    Profile findProfileByName(String name);

    void addProfileContent(Content content, Profile profile);
}
