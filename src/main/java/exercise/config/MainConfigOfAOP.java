package exercise.config;

import exercise.aop.LogAspects;
import exercise.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description AOP[底层就是动态代理] 指在程序运行期间动态地将某段代码切入到指定方法指定位置进行运行的编程
 * @date 2021/3/4 0004-20:20
 * @EnableAspectJAutoProxy 开启基于注解的aop模式
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
    // 业务逻辑加入到容器中
    @Bean
    public MathCalculator calculator(){
        return new MathCalculator();
    }

    // 切面类加入到容器中
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
