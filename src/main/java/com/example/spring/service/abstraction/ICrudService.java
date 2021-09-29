package com.example.spring.service.abstraction;

import com.example.spring.model.IModel;

import java.util.List;

public interface ICrudService<T extends IModel<K>, K> {

    void create(T t);

    T get(K key);

    List<T> getAll();

    void update(T model);

    void delete(K key);
}
