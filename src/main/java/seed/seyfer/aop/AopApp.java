package seed.seyfer.aop;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import seed.seyfer.annotationwiring.application.Logger;
import seed.seyfer.annotationwiring.application.Robot;


@Configuration
@ComponentScan("seed.seyfer.aop")
@EnableAutoConfiguration
public class AopApp {

	public static void main(String[] args) {
		classPathLoad();
	}

	private static void classPathLoad() {
		// load from resources
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/beans.xml");

        Camera camera = (Camera) applicationContext.getBean("camera");
		
		((ClassPathXmlApplicationContext) applicationContext).close();
		
		camera.snap();
	}
}
