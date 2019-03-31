package com.springboot.quickstart.controller;

import com.springboot.quickstart.dao.BookDAO;
import com.springboot.quickstart.entity.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookController {
    //注入一个BookDAO的实例
    @Resource
    private BookDAO bookDAO;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }
}
