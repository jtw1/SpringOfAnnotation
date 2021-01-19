package exercise.test;

import exercise.config.MainConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description
 * @date 2021/1/17-16:02
 */
public class IOCTest {
    @SuppressWarnings("resource")
    @Test
    public void test_1(){
        ApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext1.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }

        Object bean = applicationContext1.getBean("person");
        Object bean2 = applicationContext1.getBean("person");
        System.out.println(bean==bean2);
    }
}
