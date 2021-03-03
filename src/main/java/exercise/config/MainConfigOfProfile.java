package exercise.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description profile:Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 * @profile 指定组件在那个环境的情况下才能被注册到容器中
 * @date 2021/3/3 0003-16:42
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
    @Value("${db.usr}")
    private String user;

    private StringValueResolver valueResolver;
    private String driverClass;

    @Bean("testDataSource")
    public DataSource dataSourceOfTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser(user);
        source.setPassword(pwd);
        source.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        source.setDriverClass(driverClass);
        return source;
    }

    @Bean("devDataSource")
    public DataSource dataSourceOfDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser(user);
        source.setPassword(pwd);
        source.setJdbcUrl("jdbc:mysql://localhost:3306/ssm_crud");
        source.setDriverClass(driverClass);
        return source;
    }

    @Bean("produceDataSource")
    public DataSource dataSourceOfProduce(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource source = new ComboPooledDataSource();
        source.setUser(user);
        source.setPassword(pwd);
        source.setJdbcUrl("jdbc:mysql://localhost:3306/first");
        source.setDriverClass(driverClass);
        return source;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver=stringValueResolver;
        driverClass=valueResolver.resolveStringValue("${db.driverClass}");
    }
}
