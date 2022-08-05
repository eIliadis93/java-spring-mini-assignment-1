package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.repository.BaseRepository;
import com.acmeflix.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl extends BaseServiceImpl<Profile> implements ProfileService {

    private final ProfileRepository profileRepository;


    @Override
    public BaseRepository<Profile, Long> getRepository() {
        return profileRepository;
    }

    @Override
    public Profile findProfileByName(String name) {
        List<Profile> profiles = profileRepository.findProfileByName(name);
        if (profileRepository.findProfileByName(name).isEmpty()) {
            logger.info("No Profile with name {} exist.", name);
        }
        logger.info("Profile with name {} , found", name);
        return profiles.get(0);
    }
}
