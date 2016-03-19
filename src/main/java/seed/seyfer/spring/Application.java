package seed.seyfer.spring;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import seed.seyfer.spring.application.Person;

/**
 * Created by seyfer on 3/14/16.
 */
@Configuration
@ComponentScan("seed.seyfer.spring")
@EnableAutoConfiguration
public class Application {

	/**
	 * debug
	 */
	public static class PrintClasspath {
		public static void print() {

			// Get the System Classloader
			ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
			// ClassLoader sysClassLoader =
			// Thread.currentThread().getContextClassLoader();

			// Get the URLs
			URL[] urls = ((URLClassLoader) sysClassLoader).getURLs();

			for (int i = 0; i < urls.length; i++) {
				System.out.println(urls[i].getFile());
			}

		}
	}

	public static void main(String[] args) {

		// PrintClasspath.print();
		classPathLoad();
	}

	private static void classPathLoad() {
		// load from resources
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/beans.xml");

		Person personC = (Person) applicationContext.getBean("person");

		((ClassPathXmlApplicationContext) applicationContext).close();

		personC.speak();

		Person person = new Person();
		person.speak();
	}

	private static void fileSystemLoad() {
		// load from file system
		// ApplicationContext applicationContext = new
		// FileSystemXmlApplicationContext("beans.xml");
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext(
				"src/main/java/seed/seyfer/spring/beans/beans.xml");

		Person personC = (Person) applicationContext.getBean("person");

		((FileSystemXmlApplicationContext) applicationContext).close();

		personC.speak();

		Person person = new Person();
		person.speak();
	}

}
