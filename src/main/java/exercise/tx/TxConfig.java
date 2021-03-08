package exercise.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Description 声明式事务
 * 环境搭建：
 * 1 导入相关依赖：数据源，数据库驱动，spring-jdbc模块
 * 2 配置数据源和jdbcTemplate操作数据库
 * 3 给方法上标注@Transactional 表示当前方法是一个事务方法
 * 4 @EnableTransactionManagement 开启基于注解的事务管理功能
 * 5 配置事务管理器来控制事务
 * @date 2021/3/8 0008-19:31
 */
@EnableTransactionManagement
@ComponentScan({"exercise.tx","exercise.service","exercise.Dao"})
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class TxConfig {
    @Value("${db.usr}")
    private String user;
    @Value("${db.password}")
    private String pwd;
    @Value("${db.driverClass}")
    private String driverClass;

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/first");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        // spring对@Configuration类会特殊处理，给容器中加组件的方法，多次调用时都只是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }
    // 注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }
}
