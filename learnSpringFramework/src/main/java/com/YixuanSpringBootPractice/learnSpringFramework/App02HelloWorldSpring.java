package com.YixuanSpringBootPractice.learnSpringFramework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.YixuanSpringBootPractice.learnSpringFramework.game.GameRunner;
import com.YixuanSpringBootPractice.learnSpringFramework.game.MarioGame;
import com.YixuanSpringBootPractice.learnSpringFramework.game.SuperContraGame;

public class App02HelloWorldSpring{

	public static void main(String[] args) {

//		launch a Spring context
		var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//		configure the things that we want Spring to manage
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));

	}

}
