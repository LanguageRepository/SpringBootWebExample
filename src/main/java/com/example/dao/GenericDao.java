package com.example.dao;

import java.io.Serializable;

public interface GenericDao<T> {

    T create(T t);
    T read(int id);
    T update(T t);
    void delete(int id);

}
