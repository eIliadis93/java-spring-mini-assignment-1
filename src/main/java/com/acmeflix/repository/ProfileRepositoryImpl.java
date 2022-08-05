package com.acmeflix.repository;

import com.acmeflix.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@RequiredArgsConstructor

public class ProfileRepositoryImpl extends BaseRepositoryImpl<Profile> implements ProfileRepository {
    private final Map<Long, Profile> data = new LinkedHashMap<>();

    private final AtomicLong atomicLong = new AtomicLong(1);


    @Override
    public Map<Long, Profile> getStorage() {
        return data;
    }

    @Override
    public AtomicLong getSequence() {
        return atomicLong;
    }

    @Override
    public List<Profile> findProfileByName(String name) {
        return this.data.values().stream().filter(prof -> prof.getName().equalsIgnoreCase(name)).toList();
    }
}
