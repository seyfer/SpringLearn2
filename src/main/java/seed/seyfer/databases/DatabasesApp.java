package seed.seyfer.databases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

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
		try {
			
			Offer newOffer = new Offer("new", "new@new.com", "new one");
			int newId = offersDAO.create(newOffer);
		
			offersDAO.delete(newId);
			
			List<Offer> offersToAdd = new ArrayList<Offer>();
			offersToAdd.add(new Offer("l1", "l1@mail.ru", "l1 l1"));
			offersToAdd.add(new Offer("l2", "l2@mail.ru", "l2 l2"));
			
			offersDAO.create(offersToAdd);
			
			List<Offer> offers = offersDAO.getOffers();

			Offer mikeOffer = offersDAO.getOffer(2);
			mikeOffer.setName("mike2");
			
			offersDAO.update(mikeOffer);
			
			System.out.println("!!! \n");
			System.out.println(mikeOffer);
			System.out.println(offers);
			System.out.println("\n!!! ");

		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println(ex.getMessage());
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
		}

		((ClassPathXmlApplicationContext) applicationContext).close();
	}
}
