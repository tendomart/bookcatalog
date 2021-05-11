package controller;

import com.bookcatalog.model.Author;
import com.bookcatalog.model.Book;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorRestControllerTest {

    @Autowired
    private MockMvc mvc;
    String uri = "http://localhost:8080/author";

    String requestJsonString = null;

    @Test
    public void createAuthor_shouldCreateAuthor() throws Exception {

        Book book = new Book();
        Book book1 = new Book();
        Book book2 = new Book();

        book.setId(1);
        book.setTitle("Desire of Ages");

        book1.setId(2);
        book1.setTitle("Great controversy");

        book2.setId(3);
        book2.setTitle("Ministry of Healing");

        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        bookList.add(book1);
        bookList.add(book2);

        Author author = new Author();
        author.setId(1);
        author.setName("Ellen . G . White");
        author.setBooks(bookList);
        System.out.println(new Gson().toJson(author));
         requestJsonString = new Gson().toJson(author);

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(requestJsonString)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    public void getAuthorById_shouldReturnAuthorById(){

    }
    public void updateAuthor_shouldUpdateAuthor(){}
    public void deleteAuthor_shouldDeleteAuthor(){}
}
