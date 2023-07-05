package com.eclipseSpring.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address) { };
record Address (String city, String firstLine) { };

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name() {
        return "Name";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("N-ame", 204, new Address("Seoul", "Gang-Nam"));
    }

    //함수 호출
    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // 파라미터 구현
    @Bean
    public Person person3Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean (name = "address2")
    public Address address() {
        return new Address("Seong-nam", "Bun-dang");
    }

    @Bean (name = "address3")
    public Address address3() {
        return new Address("Busan", "Bun-dang");
    }
}
