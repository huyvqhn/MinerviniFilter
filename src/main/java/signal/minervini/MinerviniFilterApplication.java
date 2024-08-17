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

            ApplicationContext context = new AnnotationConfigApplicationContext(MinerviniFilterApplication.class);
            ConfigurableListableBeanFactory beanFactory = ((AnnotationConfigApplicationContext) context).getBeanFactory();
            Map<String, Set<String>> beanDependencies = new HashMap<>();
            String[] beanNames = context.getBeanDefinitionNames();

//            // Collect dependencies
//            for (String beanName : beanNames) {
//                String[] dependencies = beanFactory.getDependenciesForBean(beanName);
//                beanDependencies.put(beanName, new HashSet<>(Arrays.asList(dependencies)));
//            }

            printBeanDependencies(context);


//            SpringApplication.run(MinerviniFilterApplication.class, args);


        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void printBeanDependencies(ApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        Set<String> visitedBeans = new HashSet<>();
        for (String beanName : beanNames) {
            printBeanDependencies(context, beanName, 0, visitedBeans);
        }
    }

    private static void printBeanDependencies(ApplicationContext context, String beanName, int level, Set<String> visitedBeans) {
        if (visitedBeans.contains(beanName)) {
            return;
        }
        visitedBeans.add(beanName);

        BeanDefinition beanDefinition = ((AnnotationConfigApplicationContext) context).getBeanFactory().getBeanDefinition(beanName);
        System.out.println(" ".repeat(level * 2) + beanName);

        String[] dependencies = beanDefinition.getDependsOn();
        if (dependencies != null) {
            for (String dependency : dependencies) {
                printBeanDependencies(context, dependency, level + 1, visitedBeans);
            }
        }
    }

}
