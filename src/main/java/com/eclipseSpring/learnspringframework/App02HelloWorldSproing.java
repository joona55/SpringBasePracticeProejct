package com.eclipseSpring.learnspringframework;

import org.springframework.boot.autoconfigure.web.reactive.HttpHandlerAutoConfiguration.AnnotationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSproing {

	public static void main(String[] args) {
		var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));
		System.out.println(context.getBean("address"));
		// Address 클레스로 구현된 함수가 여러개 빈에 등록되있다면 에러가 난다.
		System.out.println(context.getBean(Address.class));

	}

}
