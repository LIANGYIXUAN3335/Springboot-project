package com.YixuanSpringBootPractice.learnSpringFramework.helloword;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {};
record Address(String street ,String city) {};
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
	@Primary
	public Person person() {
		var person = new Person("Ravi",20,address());
		return person;
	}
	@Bean(name = "person2")
	public Person person2MethodCall() {
		var person = new Person(name(),age(),address());
		return person;
	}
	@Bean(name = "person3Parameters")
	// we can use bean name in the input parameter
	public Person person3Parameters(String name, int age, @Qualifier("address3qualifier")Address address) {
		var person = new Person(name,age,address);
		return person;
	}
	@Bean(name = "address2")
	@Primary
	public Address address() {
		return new Address("Wentworth AVE","Chicago");
	}
	@Bean(name = "address3")
	@Qualifier("address3qualifier")
	public Address address3() {
		return new Address("Baker Street","London");
	}
}
