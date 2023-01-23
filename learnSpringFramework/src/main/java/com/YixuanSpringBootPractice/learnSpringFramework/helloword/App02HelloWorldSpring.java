package com.YixuanSpringBootPractice.learnSpringFramework.helloword;
import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring{

	public static void main(String[] args) {

//		launch a Spring context
		try(var context = 
				new AnnotationConfigApplicationContext(
						HelloWorldConfiguration.class)){
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean("person3Parameters"));
			System.out.println(context.getBean("address2"));
	// when there is only one default return then we can use Address.class, 
			//otherwise we can not use this type of writing
			System.out.println(context.getBean(Address.class));
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		}
//		configure the things that we want Spring to manage
		
	}

}
