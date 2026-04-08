package com.ams.common;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity> {

    T create(T entity);

    Optional<T> findById(Long id);

    List<T> findAll();

    T update(T entity);

    void delete(Long id);

    boolean exists(Long id);
}
