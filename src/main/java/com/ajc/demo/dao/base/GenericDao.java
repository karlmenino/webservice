package com.ajc.demo.dao.base;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T, ID extends Number> {

    ID save(T object);

    List<T> findAll();

    Optional<T> findById(ID id);

    boolean update(T object);

    void delete(ID id);
}
