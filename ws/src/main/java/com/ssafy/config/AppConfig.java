package com.ssafy.config;

//TODO: 필요한 Spring 어노테이션 및 모델 클래스 import 문을 추가하세요
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.dto.BookPrinter;


//TODO: @Configuration 어노테이션 적용
@Configuration
//TODO: @ComponentScan 어노테이션 적용
@ComponentScan(basePackages = "com.ssafy")
public class AppConfig {

	// @Bean 메서드 모두 삭제	
}
