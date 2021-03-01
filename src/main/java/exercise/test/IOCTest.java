package exercise.test;

import exercise.config.MainConfig;
import exercise.config.MainConfigOfLIfeCycle;
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

    @Test
    public void test_LifeCycle(){
        // 创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLIfeCycle.class);
        System.out.println("容器创建完成");

        context.close();
        System.out.println("容器关闭");
    }
}
