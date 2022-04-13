package com.digipera.repositories;

import android.content.Context;

import com.digipera.repositories.configs.BasicConfig;

import java.util.List;


public abstract class BasicRepository<T, E> {

    protected DBFactory factory;

    public BasicRepository(Context context, BasicConfig config, String createTable, String dropTable) {
        factory = new DBFactory(context, config, createTable, dropTable);
    }

    public abstract void insert(T object);
    public abstract void insertAll(List<T> object);
    public abstract void update(T object, E key);

    public abstract void delete(E key);

    public abstract T get(E key);

    public abstract List<T> getAll(E key);

}