package com.ssafy.ws;
//TODO: Logger 관련 import문을 작성하세요
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.ws.model.dto.Book;

public class BookApp {

 // TODO: Logger 객체를 생성하세요
 private static final Logger logger = LoggerFactory.getLogger(BookApp.class);

 public static void main(String[] args) {
     // TODO: 시스템 시작 로그를 출력하세요 (INFO)
     logger.info("=== SSAFY 도서관 시스템 시작 ===");

     Book book1 = new Book("978-1", "Java 기초", "김싸피", 25000);
     Book book2 = new Book("978-2", "Spring 마스터", "박싸피", 45000);

     logger.info("도서 등록: {}", book1);
     logger.info("도서 등록: {}", book2);

     // TODO: checkPriceWarning 메서드를 호출하여 조건부 로깅을 테스트하세요.
     checkPriceWarning(book1);
     checkPriceWarning(book2);

     // TODO: 음수 가격으로 Book 생성을 시도하고 예외를 catch하여 로그로 출력하세요.
     try {
         Book invalidBook = new Book("978-3", "잘못된 도서", "이싸피", -1000);
         logger.info("도서 등록: {}", invalidBook);

     } catch (IllegalArgumentException e) {
         logger.error("도서 등록 실패 - 잘못된 가격: {}", e.getMessage(), e);

     }
     
     logger.info("=== 시스템 종료 ===");

 }

 private static void logBook(Book book) {
     // TODO: 도서 등록 로그를 출력하세요 (INFO)
     logger.info("도서 등록: {}", book);

     // TODO: 도서 가격 로그를 출력하세요 (DEBUG)
     logger.debug("도서 가격: {}원", book.getPrice());

     // TODO: 고가 도서 경고를 출력하세요 (WARN)
     // 조건: 가격이 30,000원을 초과하는 경우
     if (book.getPrice() > 30000) {
         logger.warn("고가 도서 경고: {} ({}원)", book.getTitle(), book.getPrice());
     }

 }
 
 private static void checkPriceWarning(Book book) {
     // TODO: 가격이 30000원 초과이면 WARN, 그 외에는 INFO 레벨로 로그를 출력하세요.
     // WARN: "고가 도서 경고: {제목} ({가격}원)"
     // INFO: "일반 도서: {제목} ({가격}원)"
     if (book.getPrice() > 30000) {
         logger.warn("고가 도서 경고: {} ({}원)", book.getTitle(), book.getPrice());
     } else {
         logger.info("일반 도서: {} ({}원)", book.getTitle(), book.getPrice());
     }
 }
}
