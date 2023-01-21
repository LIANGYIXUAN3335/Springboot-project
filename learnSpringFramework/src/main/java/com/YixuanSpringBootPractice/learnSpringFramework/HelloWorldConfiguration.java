package com.YixuanSpringBootPractice.learnSpringFramework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) {};

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Ranga";
	}
	@Bean
	public int age() {
		return 15;
	}
	@Bean(name = "person")
	public Person p12erson() {
		var person = new Person("Ravi",20);
		return person;
	}
}
