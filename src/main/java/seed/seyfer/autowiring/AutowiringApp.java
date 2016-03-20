package seed.seyfer.autowiring;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import seed.seyfer.autowiring.application.Logger;
import seed.seyfer.autowiring.application.LoggerAmbigous;

@Configuration
@ComponentScan("seed.seyfer.autowiring")
@EnableAutoConfiguration
public class AutowiringApp {

	public static void main(String[] args) {
		classPathLoad();
	}

	private static void classPathLoad() {
		// load from resources
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowiring/beans.xml");

//		Logger logger = (Logger) applicationContext.getBean("logger");
		
		LoggerAmbigous logger = (LoggerAmbigous) applicationContext.getBean("loggerAmbigous");
		
		((ClassPathXmlApplicationContext) applicationContext).close();

		logger.writeConsole("hi");
		logger.writeFile("hello");
	}
}
