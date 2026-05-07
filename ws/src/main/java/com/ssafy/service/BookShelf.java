package com.ssafy.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ssafy.ws.model.dto.Book;

@Component
public class BookShelf {
	private List<Book> list;
	
    public BookShelf() {
        list = new ArrayList<>();

        list.add(new Book(null, "Good Code", "James Ssafy", 0));
        list.add(new Book(null, "Practical Java", "박싸피", 0));
    }

    // 책 추가
    public void addBook(Book book) {
        list.add(book);
    }

    // 책 목록 반환
    public List<Book> getBooks() {
        return list;
    }
}
