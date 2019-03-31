package com.springboot.quickstart.dao;

import com.springboot.quickstart.entity.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 图书的DAO类
 */
@Component
public class BookDAO {
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Spring Boot实战", 88.7));
        books.add(new Book(2, "Spring MVC", 98.7));
        books.add(new Book(3, "Java从入门到精通", 68.7));
        return books;
    }
}
