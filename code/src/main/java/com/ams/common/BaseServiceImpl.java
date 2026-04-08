package com.ams.common;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    protected abstract BaseRepository<T> getRepository();

    @Override
    public T create(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public Optional<T> findById(Long id) {
        return getRepository().findById(id);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T update(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return getRepository().existsById(id);
    }
}
