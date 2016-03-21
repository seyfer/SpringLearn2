package seed.seyfer.annotationwiring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import seed.seyfer.annotationwiring.application.Logger;
import seed.seyfer.annotationwiring.application.Robot;


@Configuration
@ComponentScan("seed.seyfer.annotationwiring")
@EnableAutoConfiguration
public class AnnotationwiringApp {

	public static void main(String[] args) {
		classPathLoad();
	}

	private static void classPathLoad() {
		// load from resources
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotationwiring/beans.xml");

		Logger logger = (Logger) applicationContext.getBean("logger");
		Robot robot = (Robot)applicationContext.getBean("robot");

		((ClassPathXmlApplicationContext) applicationContext).close();

		logger.writeConsole("hi");
		logger.writeFile("hello");
		robot.speak();
	}
}
