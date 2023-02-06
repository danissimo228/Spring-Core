package ru.nishpal.learning;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.nishpal.learning.config.SpringConfig;
import ru.nishpal.learning.entity.Person;
import ru.nishpal.learning.entity.SuperUser;

@SpringBootApplication
public class LearningApplication {

	public static void main(String[] args) throws InterruptedException {
//		SpringApplication.run(LearningApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringConfig.class
		);

//		while (true) {
//			Thread.sleep(100);
//			context.getBean(Person.class);
//		}

		context.getBean(Person.class);
	}
}
