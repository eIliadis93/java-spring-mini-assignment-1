package com.acmeflix.repository;

import com.acmeflix.domain.BaseModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public abstract class BaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T, Long> {
    public abstract Map<Long, T> getStorage();

    protected Logger logger = LoggerFactory.getLogger(getClass());


    public abstract AtomicLong getSequence();

    @Override
    public T create(final T entity) {
        final Long key;
        key = getSequence().getAndIncrement();
        entity.setId(key);
        getStorage().put(key, entity);
        logger.trace("Just created entity with id : {}.", entity.getId());
        return entity;
    }

    @Override
    public void update(final T entity) {
        getStorage().put(entity.getId(), entity);
        logger.trace("Just updated entity with id : {}.", entity.getId());
    }

    @Override
    public void delete(final T entity) {
        final Long id = entity.getId();
        deleteById(id);
        logger.trace("Just deleted entity with id : {}.", id);
    }

    @Override
    public void deleteById(final Long id) {
        if (getStorage().remove(id) != null)
            logger.trace("Just deleted entity with given id :{}", id);
        else
            logger.trace("Couldn't delete entity with given id :{}", id);

    }

    @Override
    public boolean exists(final T entity) {
        boolean found = Objects.nonNull(getStorage().get(entity.getId()));
        logger.trace("Just found entity with id : {}.", entity.getId());
        return found;
    }

    @Override
    public T get(final Long id) {
        return getStorage().get(id);
    }

    @Override
    public List<T> findAll() {
        return getStorage().values().stream().toList();
    }

}
