package seed.seyfer.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import seed.seyfer.spring.application.Person;
import seed.seyfer.spring.domain.Developer;
import seed.seyfer.spring.domain.DeveloperRepository;
import seed.seyfer.spring.domain.Skill;
import seed.seyfer.spring.domain.SkillRepository;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by seyfer on 3/14/16.
 */
@SpringBootApplication
@Configuration
@ComponentScan("seed.seyfer.spring")
@EnableAutoConfiguration
public class Application implements CommandLineRunner {

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    SkillRepository skillRepository;

    /**
     * debug
     */
    public static class PrintClasspath {
        public static void print() {

            //Get the System Classloader
            ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();
//            ClassLoader sysClassLoader = Thread.currentThread().getContextClassLoader();

            //Get the URLs
            URL[] urls = ((URLClassLoader) sysClassLoader).getURLs();

            for (int i = 0; i < urls.length; i++) {
                System.out.println(urls[i].getFile());
            }

        }
    }

    public static void main(String[] args) {

//        PrintClasspath.print();

        //load from file system
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("beans.xml");
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/main/java/seed/seyfer/spring/beans/beans.xml");

        //load from resources
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/beans.xml");

        Person personC = (Person) applicationContext.getBean("person");

//        ((FileSystemXmlApplicationContext) applicationContext).close();
        ((ClassPathXmlApplicationContext) applicationContext).close();

        personC.speak();

        Person person = new Person();
        person.speak();

        //it will run tomcat with spring boot
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {
        Skill javascript = new Skill("javascript", "Javascript language skill");
        Skill ruby = new Skill("ruby", "Ruby language skill");
        Skill emberjs = new Skill("emberjs", "Emberjs framework");
        Skill angularjs = new Skill("angularjs", "Angularjs framework");

        skillRepository.save(javascript);
        skillRepository.save(ruby);
        skillRepository.save(emberjs);
        skillRepository.save(angularjs);

        List<Developer> developers = new LinkedList<Developer>();
        developers.add(new Developer("John", "Smith", "john.smith@example.com",
                Arrays.asList(new Skill[]{javascript, ruby})));
        developers.add(new Developer("Mark", "Johnson", "mjohnson@example.com",
                Arrays.asList(new Skill[]{emberjs, ruby})));
        developers.add(new Developer("Michael", "Williams", "michael.williams@example.com",
                Arrays.asList(new Skill[]{angularjs, ruby})));
        developers.add(new Developer("Fred", "Miller", "f.miller@example.com",
                Arrays.asList(new Skill[]{emberjs, angularjs, javascript})));
        developers.add(new Developer("Bob", "Brown", "brown@example.com",
                Arrays.asList(new Skill[]{emberjs})));
        developerRepository.save(developers);
    }
}
