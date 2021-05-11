package com.bookcatalog.controller;

import com.bookcatalog.dao.BookRepository;
import com.bookcatalog.model.Author;
import com.bookcatalog.model.Book;
import com.bookcatalog.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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

import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/book")
public class BookRestController {

    @Autowired
    BookRepository bookdao;

    Book bk = new Book();

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        try {
            Book book = bookdao.findById(id).get();
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        if(book.toString().equals("{}")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
          bk = new Book();
          bk.setId(book.getId());
          bk.setTitle(book.getTitle());
          bookdao.save(bk);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Integer id){
        try {
            Book book1 = bookdao.findById(id).get();
            bookdao.save(book);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Integer id){
        try {
            bookdao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.GONE);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
