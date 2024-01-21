package com.mjc.school.repository;

import java.util.List;

public interface Interface<T> {
    List<T> readAll();

    T readById(Long id);

    T create(T model);

    T updateNewsById(T model);

    Boolean deleteById(Long id);
}
