package com.ssafy.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//TODO: 필요한 어노테이션을 import 하세요.

import com.ssafy.ws.model.dao.BookDao;
import com.ssafy.ws.service.BookService;

@Configuration
public class AppConfig {

 @Bean
 public BookDao bookDao() {
     // TODO: BookDao 인스턴스를 생성하여 반환하세요.
     return new BookDao();
 }

 @Bean
 public BookService bookService() {
     // TODO: BookService 인스턴스를 생성하여 반환하세요.
     // 힌트: 생성자 의존성 주입을 위해 다른 @Bean 메서드를 활용하세요.
     return new BookService(bookDao()); // bookDao()는 새 객체가 아니라 기존Bean이 주입된다.
 }
}