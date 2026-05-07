package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssafy.ws.model.dto.Book;

@Component
public class BookManager {
	
	private final BookShelf bookShelf;
	
	@Autowired
	public BookManager(BookShelf bookShelf) {
		this.bookShelf = bookShelf;
	}
	
    public void printAllBooks() {
        System.out.println("=== BookShelf의 모든 책 목록 ===");

        for (Book book : bookShelf.getBooks()) {
            System.out.println(book);
        }
    }
}
