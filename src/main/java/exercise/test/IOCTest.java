package exercise.test;

import exercise.Dao.PersonDao;
import exercise.aop.MathCalculator;
import exercise.bean.Person;
import exercise.config.*;
import exercise.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

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

    @Test
    public void testProfile(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //先创建一个applicationContext，再设置需要激活的环境
        context.getEnvironment().setActiveProfiles("develop","Test");
        // 再注册主配置类，
        context.register(MainConfigOfProfile.class);
        // 再启动刷新容器
        context.refresh();

        String[] dataSources = context.getBeanNamesForType(DataSource.class);
        for (String str : dataSources) {
            System.out.println(str);
        }
    }

    @Test
    public void testAOP(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        // 不要自己创建对象，要使用spring容器中的对象
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(6,2);
    }


    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] BeanNames=applicationContext.getBeanDefinitionNames();
        for(String name:BeanNames){
            System.out.println(name);
        }
    }
}
