package com.ssafy.ws.step3.service;

import java.util.List;

import com.ssafy.ws.step3.dao.BookDao;
import com.ssafy.ws.step3.dto.Book;

public class BookService {

    private static final BookService instance = new BookService();

    private final BookDao dao = BookDao.getInstance();

    private BookService() {
    }

    public static BookService getInstance() {
        return instance;
    }

    public void regist(Book book) {
        dao.insert(book);
    }

    public List<Book> getList() {
        return dao.selectAll();
    }
}
