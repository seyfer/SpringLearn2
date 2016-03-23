package seed.seyfer.databases;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import seed.seyfer.databases.application.Robot;

@Configuration
@ComponentScan("seed.seyfer.databases")
@EnableAutoConfiguration
public class DatabasesApp {
	public static void main(String[] args) {
		classPathLoad();
	}

	private static void classPathLoad() {
		// load from resources
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("databases/beans.xml");

		Robot robot = (Robot) applicationContext.getBean("robot");

		((ClassPathXmlApplicationContext) applicationContext).close();

		robot.speak();
	}
}
