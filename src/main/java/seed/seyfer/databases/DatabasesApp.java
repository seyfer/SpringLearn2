package seed.seyfer.databases;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import seed.seyfer.databases.application.Offer;
import seed.seyfer.databases.application.OffersDAO;
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
		OffersDAO offersDAO = (OffersDAO) applicationContext.getBean("offersDao");

		robot.speak();
		
		List<Offer> offers = offersDAO.getOffers();
		
		System.out.println("!!! \n");
		System.out.println(offers);
		System.out.println("\n!!! ");
		
		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
