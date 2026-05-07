package com.ssafy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ssafy.config.AppConfig;
import com.ssafy.service.BookManager;
import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.BookPrinter;

public class MainApp {
    public static void main(String[] args) {
        // TODO: AnnotationConfigApplicationContext 생성 (AppConfig.class 사용)
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // BookManager Bean 조회
        BookManager bookManager = ctx.getBean(BookManager.class);

        // 전체 책 출력
        bookManager.printAllBooks();
    }
}