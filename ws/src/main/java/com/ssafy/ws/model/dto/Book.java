package com.ssafy.ws.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private String isbn;
    private String title;
    private String author;
    private int price;

//    public Book(String isbn, String title, String author, int price) {
//        this.isbn = isbn;
//        this.title = title;
//        this.author = author;
//        this.price = price;
//    }

}