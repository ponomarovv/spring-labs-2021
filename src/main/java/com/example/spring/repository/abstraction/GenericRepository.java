package com.example.spring.repository.abstraction;

import com.example.spring.model.IModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class GenericRepository<T extends IModel<K>, K> implements IGenericRepository<T, K> {

    protected Map<K, T> entities;

    protected GenericRepository() {
        entities = new HashMap<>();
    }

    @Override
    public void create(T entity) {
        entities.put(entity.getId(), entity);
    }

    @Override
    public T read(K key) {
        return entities.get(key);
    }

    @Override
    public boolean update(T entity) {
        if (!entities.containsKey(entity.getId())) {
            return false;
        }
        entities.replace(entity.getId(), entity);
        return true;
    }

    @Override
    public void delete(K key) {
        entities.remove(key);
    }

    @Override
    public List<T> readAll() {
        return new ArrayList<>(entities.values());
    }
}
