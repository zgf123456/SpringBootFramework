package com.fastdev.sample.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by zgf on 17/4/10.
 */
@Configuration
@ComponentScan
@MapperScan("com.fastdev.sample.mybatis")
// 多数据源配置
//@MapperScan(basePackages = "com.fastdev.sample", sqlSessionFactoryRef = "fqlSqlSessionFactory", annotationClass = FqlMybatisMapper.class)
//@PropertySource("classpath:db.properties")
public class DruidDataSourceConfig {
    private Logger logger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Value("${jdbc.driver}")
    private String jdbcDriver;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${jdbc.initialSize}")
    private String jdbcInitialSize;
    @Value("${jdbc.maxActive}")
    private String jdbcMaxActive;
    @Value("${jdbc.minIdle}")
    private String jdbcMinIdle;
    @Value("${jdbc.maxWait}")
    private String jdbcMaxWait;
    @Value("${jdbc.validationQuery}")
    private String jdbcValidationQuery;

    @Autowired
    private DataSource fastdevDataSource;

    @Bean(name = "fastdevDataSource")
    public DataSource fastdevDataSource() throws Exception {
        logger.info("-------------------- datasource init ---------------------");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbcDriver);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(jdbcUserName);
        druidDataSource.setPassword(jdbcPassword);

        //配置初始化大小、最小、最大
        druidDataSource.setInitialSize(Integer.parseInt(jdbcInitialSize));
        druidDataSource.setMinIdle(Integer.parseInt(jdbcMinIdle));
        druidDataSource.setMaxActive(Integer.parseInt(jdbcMaxActive));

        //配置获取连接等待超时的时间
        druidDataSource.setMaxWait(Integer.parseInt(jdbcMaxWait));

        //链接检测
        //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenEvictionRunsMillis(3000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery(jdbcValidationQuery);
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeout(3000);

        Properties connectProperties = new Properties();
        connectProperties.setProperty("druid.stat.slowSqlMillis", "3000");
        druidDataSource.setConnectProperties(connectProperties);
        return druidDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(fastdevDataSource);

        //添加XML目录
        try {
            //每张表对应的xml文件
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
            bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "fastdevTransactionManager")
    public DataSourceTransactionManager fastdevTransactionManager() {
        return new DataSourceTransactionManager(fastdevDataSource);
    }
}
