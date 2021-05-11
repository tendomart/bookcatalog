package com.bookcatalog.service;

import com.bookcatalog.model.Book;

public interface CatalogService<T> {

    public T getItemById(int id);

    public void create(T item);

    public void update(T item);

    public void delete(T item);
}
