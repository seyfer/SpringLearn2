package seed.seyfer.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import seed.seyfer.example.application.Printer;

/**
 * Created by seyfer on 3/14/16.
 */
@Configuration
@ComponentScan("seed.seyfer.example")
@EnableAutoConfiguration
public class ExampleApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExampleApp.class);

        Printer printer = context.getBean(Printer.class);
        printer.printMessage();
        
        context.close();
    }
}
