package com.bookcatalog.service;

import com.bookcatalog.dao.AuthorRepository;
import com.bookcatalog.model.Author;
import com.bookcatalog.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements  CatalogService<Author>{

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author getItemById(int id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public void create(Author item) {
       authorRepository.save(item);
    }

    @Override
    public void update(Author item) {
        authorRepository.save(item);
    }

    @Override
    public void delete(Author item) {
        authorRepository.delete(item);
    }
}
