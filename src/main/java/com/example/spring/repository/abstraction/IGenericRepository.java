package com.example.spring.repository.abstraction;

import com.example.spring.entity.IModel;

import java.util.List;

public interface IGenericRepository<T extends IModel<K>, K> {

    void create(T entity);

    T read(K key);

    boolean update(T entity);

    void delete(K key);

    List<T> readAll();
}
