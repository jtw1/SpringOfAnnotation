package exercise.config;

import exercise.bean.car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @date 2021/3/1 0001-20:47
 */
@ComponentScan("exercise.bean")
@Configuration
public class MainConfigOfLIfeCycle {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public car car(){
        return new car();
    }
}
