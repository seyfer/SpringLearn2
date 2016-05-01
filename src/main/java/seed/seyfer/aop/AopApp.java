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

		Object obj = applicationContext.getBean("camera");
		System.out.println("Camera bean class " + obj.getClass());
		System.out.println(obj instanceof Camera);
		
		CameraInterface camera = (CameraInterface) applicationContext.getBean("camera");
		Lens lens = (Lens) applicationContext.getBean("lens");

		((ClassPathXmlApplicationContext) applicationContext).close();

		camera.snap();
		System.out.println("\n");
		camera.snap(1000);
		System.out.println("\n");
		camera.snap("name");
		System.out.println("\n");
		camera.snapNighttime();
		System.out.println("\n");
		
		lens.zoom(5);
		System.out.println("\n");
	}
}
