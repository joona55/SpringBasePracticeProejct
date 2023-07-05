package com.eclipseSpring.learnspringframework;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

public class App02HelloWorldSproing {

	public static void main(String[] args) {
		var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
		System.out.println(context.getBean("address2"));
		// Address 클레스로 구현된 함수가 여러 개 생성되어 빈에 등록되있다면 에러가 난다.
		// 1. 하나의 빈을 @Primary 어노테이션을 통해 기본값으로 설정
		System.out.println(context.getBean(Address.class));
		System.out.println(context.getBean(Person.class));
		// 2. @Qualifire를 설정 후 다른 파라미터 내의 @Qualifire("이름")을 통해 Bean 간의 연결을 시켜준다.
		System.out.println(context.getBean("person5Qualifire"));

		//System.out.println
		Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
									//메서드 참조

	}

}
