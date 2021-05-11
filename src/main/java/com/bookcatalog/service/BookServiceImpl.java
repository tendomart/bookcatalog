package com.bookcatalog.service;

import com.bookcatalog.dao.BookRepository;
import com.bookcatalog.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements CatalogService<Book> {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book getItemById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void create(Book item) {
       bookRepository.save(item);
    }

    @Override
    public void update(Book item) {
        bookRepository.save(item);
    }

    @Override
    public void delete(Book item) {
       bookRepository.delete(item);
    }
}
