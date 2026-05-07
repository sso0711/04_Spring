package com.ssafy.hw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//TODO: 필요한 import 문을 추가하세요.

/**
* Spring Java 기반 설정 클래스
**/
@Configuration
@ComponentScan(basePackages = "com.ssafy.hw")
public class MovieConfig {
 // 컴포넌트 스캔을 통해 @Component, @Service, @Repository 등의
 // 어노테이션이 붙은 클래스를 자동으로 빈으로 등록합니다.
}
