package signal.minervini.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class BeanDependencyPrinter {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanDependencyPrinter.class);
        printBeanDependencies(context);
    }

    @Bean
    public String exampleBean() {
        return "exampleBean";
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
