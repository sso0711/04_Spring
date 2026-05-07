package com.ssafy.ws.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ssafy.ws.service.GreetingService;
//TODO: 필요한 import 문을 추가하세요.

/**
 * 애플리케이션 시작 시 실행되는 Runner
 *
 * TODO: @Component 어노테이션을 추가하세요.
 */
//TODO: 적절한 어노테이션을 추가하세요.
@Component
public class AppRunner implements CommandLineRunner {

	// TODO: GreetingService를 final 필드로 선언하세요.
    private final GreetingService greetingService;

    // TODO: 생성자를 작성하여 GreetingService를 주입받으세요.
    public AppRunner(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("========================================");
        System.out.println("  Welcome to Spring Boot Application");
        System.out.println("========================================");
        // TODO: greetingService.greet("SSAFY")를 호출하여 출력하세요.
        System.out.println(greetingService.greet("SSAFY"));
        System.out.println("========================================");
    }
}
