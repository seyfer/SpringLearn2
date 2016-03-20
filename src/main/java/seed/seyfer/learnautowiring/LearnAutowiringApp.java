package seed.seyfer.learnautowiring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan("seed.seyfer.spring")
@EnableAutoConfiguration
public class LearnAutowiringApp {

	public static void main(String[] args) {
		classPathLoad();
	}

	private static void classPathLoad() {
		// load from resources
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("learnautowiring/beans.xml");

		((ClassPathXmlApplicationContext) applicationContext).close();

		// System.out.println(personC);
	}
}
