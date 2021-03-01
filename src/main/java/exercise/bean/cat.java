package exercise.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Description 2. 通过Bean实现 InitializingBean(定义初始化逻辑)        DisposableBean(定义销毁逻辑)
 * @date 2021/3/1 0001-21:17
 */
@Component
public class cat implements InitializingBean, DisposableBean{
    public cat(){
        System.out.println("cat constructing...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("car afterPropertiesSet...");
    }
}
