package exercise.test;

import exercise.Dao.PersonDao;
import exercise.bean.Person;
import exercise.config.MainConfig;
import exercise.config.MainConfigOfAutowired;
import exercise.config.MainConfigOfLIfeCycle;
import exercise.config.MainConfigOfPropertyValue;
import exercise.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

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

    @Test
    public void test_PropertyValue(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        printBeans(applicationContext);
        System.out.println("============");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("person.name");
        System.out.println(property);
        applicationContext.close();
    }

    @Test
    public void test_Autowired(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        PersonService bookService = annotationConfigApplicationContext.getBean(PersonService.class);
        System.out.println(bookService);

        PersonDao personDao = annotationConfigApplicationContext.getBean(PersonDao.class);
        System.out.println(personDao);

        annotationConfigApplicationContext.close();
    }


    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] BeanNames=applicationContext.getBeanDefinitionNames();
        for(String name:BeanNames){
            System.out.println(name);
        }
    }
}
