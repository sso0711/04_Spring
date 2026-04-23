package com.ssafy.ws.step3.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step3.dto.Book;

public class BookDao {

    private static final BookDao instance = new BookDao();

    private final List<Book> bookList = new ArrayList<>();

    private BookDao() {
    }

    public static BookDao getInstance() {
        return instance;
    }

    public void insert(Book book) {
        bookList.add(book);
    }

    public List<Book> selectAll() {
        return new ArrayList<>(bookList);
    }
}
