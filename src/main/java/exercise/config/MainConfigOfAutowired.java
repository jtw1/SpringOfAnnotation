package exercise.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description  自动装配  Spring利用依赖注入(DI) 完成对IOC容器中各个组件的依赖关系赋值
 * @date 2021/3/2 0002-17:30
 */
@Configuration
@ComponentScan({"exercise.service","exercise.Dao","exercise.controller"})
public class MainConfigOfAutowired {
}
