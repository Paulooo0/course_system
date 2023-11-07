package br.com.pauloh.dao.generic;

import java.util.List;

public interface IGenericDAO<T> {
    T create(T entity);

    T read(Long id);

    T update(T entity);

    void delete(T entity);

    List<T> findAll();
}
