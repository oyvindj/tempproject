package no.tine.starterkit.repository;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<T, ID extends Serializable> {


    T find(ID id);

    List<T> findAll();

    T update(T entity);

    T create(T entity);

    List<T> create(List<T> entities);

    void delete(T entity);

    void delete(List<T> entities);

}