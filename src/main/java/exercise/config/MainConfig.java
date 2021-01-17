package exercise.config;

import exercise.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Description 配置类（Java代码）等同于以前的配置文件（xml文件）
 * @date 2021/1/17-15:39
 */
@Configuration //告诉spring这是个配置文件
@ComponentScan(value = "exercise",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)
//value:指定要扫描的包
// excludeFilters=Filter[] 指定扫描时按照什么规则排除那些组件
// includeFilters=Filter[] 指定扫描时只需要包含那些组件
public class MainConfig {
    @Bean("person")
    //给容器中注册一个bean
    //类型是返回值类型   id默认是方法名
    public Person getPerson(){
        return new Person("jtw",23);
    }
}
