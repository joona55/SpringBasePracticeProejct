package com.eclipseSpring.learnspringframework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    public Person person3Parameters(String name, int age, Address address2) {
        return new Person(name, age, address2);
    }

    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) {
        return new Person(name, age, address);
    }

    @Bean
    public Person person5Qualifire(String name, int age, @Qualifier("address2qualifire") Address address) {
        return new Person(name, age, address);
    }

    @Bean (name = "address1")
    @Primary
    public Address address() {
        return new Address("Seongnam", "Bundang");
    }

    @Bean (name = "address2")
    @Qualifier("address2qualifire")
    public Address address2() {
        return new Address("Deajeun", "Junggu");
    }
}
