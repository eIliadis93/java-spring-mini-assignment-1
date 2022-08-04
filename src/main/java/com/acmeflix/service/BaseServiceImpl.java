package com.acmeflix.service;

import com.acmeflix.BaseComponent;
import com.acmeflix.domain.BaseModel;
import com.acmeflix.repository.BaseRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> extends BaseComponent implements BaseService<T, Long> {
    public abstract BaseRepository<T, Long> getRepository();

    @Override
    public T create(final T item) {
        T savedItem = getRepository().create(item);
        logger.debug("Just Created item :{}.", savedItem);
        return savedItem;
    }

    @Override
    public List<T> createAll(final T... items) {
        return createAll(Arrays.asList(items));
    }

    @Override
    public List<T> createAll(final List<T> items) {
        final List<T> updatedItems = new ArrayList<>();
        for (final T item : items) {
            updatedItems.add(create(item));
        }
        return updatedItems;
    }

    @Override
    public void update(final T item) {
        getRepository().update(item);
    }

    @Override
    public void delete(final T item) {
        getRepository().delete(item);
    }

    @Override
    public void deleteById(final Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(final T item) {

        if(getRepository().exists(item)) {
            logger.trace("Item :{} exists", item);
            return true;
        }else
            logger.trace("Item :{} does not exists",item);

        return false;
    }

    @Override
    public T get(final Long id) {
        T item = getRepository().get(id);
        logger.trace("Item found matching id:{}.", id);
        return item;
    }

    @Override
    public List<T> findAll() {
        List<T> itemsFound = getRepository().findAll();
        logger.trace("Returned {} items.", itemsFound.size());
        return itemsFound;
    }
}
