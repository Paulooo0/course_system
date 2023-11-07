package br.com.pauloh.dao.generic;

public interface IGenericDAO<T> {
    T create(T entity);

    T read(Long id);

    T update(Long id);

    void delete(Long id);
}
