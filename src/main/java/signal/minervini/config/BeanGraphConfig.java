package signal.minervini.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGraphConfig {

//    @Bean
    public BeanPostProcessor beanPostProcessor() {
//        return new BeanPostProcessor() {
//            @Override
//            public Object postProcessBeforeInitialization(Object bean, String beanName) {
//                System.out.println("Initializing bean: " + beanName + " of type " + bean.getClass().getName());
//                return bean;
//            }
//
//            @Override
//            public Object postProcessAfterInitialization(Object bean, String beanName) {
//                return bean;
//            }
//        };
        return null;
    }
}
