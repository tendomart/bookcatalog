package com.bookcatalog.controller;

import com.bookcatalog.dao.AuthorRepository;
import com.bookcatalog.dao.BookRepository;
import com.bookcatalog.model.Author;
import com.bookcatalog.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/author")
public class AuthorRestController {

    @Autowired
    AuthorRepository authorDao;

    Author author = new Author();

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Integer id) throws Exception{
        try {
            Author author1 = authorDao.findById(id).get();
            return new ResponseEntity<Author>(author1, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Author>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Book> createAuthor(@RequestBody Author author1){
        if(author1.toString().equals("{}")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        author = new Author();
        author.setId(author1.getId());
        author.setName(author1.getName());
        authorDao.save(author);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateAuthor(@RequestBody Author author, @PathVariable Integer id){
        try {
            author = authorDao.findById(id).get();
            authorDao.save(author);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteAuthor(@PathVariable Integer id){
        try {
            authorDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.GONE);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
