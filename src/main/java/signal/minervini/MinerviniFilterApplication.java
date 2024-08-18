package signal.minervini;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import signal.minervini.config.AppConfig;

import java.util.*;

@SpringBootApplication
@Configuration
public class MinerviniFilterApplication {

    public static void main(String[] args) {
        try {


            SpringApplication.run(MinerviniFilterApplication.class, args);


        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
