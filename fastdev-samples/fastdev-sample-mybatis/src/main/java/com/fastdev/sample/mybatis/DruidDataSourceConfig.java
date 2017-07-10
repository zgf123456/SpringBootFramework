package com.fastdev.sample.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.fastdev.sample.mybatis.plugin.MybatisLogInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * Created by zgf on 17/4/10.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan
@MapperScan("com.fastdev.sample.mybatis")
public class DruidDataSourceConfig implements TransactionManagementConfigurer {
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
    private DataSource dataSource;

    @Bean
    public DataSource dataSource() throws Exception {
        logger.info("-------------------- datasource init ---------------------");
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(jdbcDriver);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(jdbcUserName);
        druidDataSource.setPassword(jdbcPassword);
        druidDataSource.setMaxActive(Integer.parseInt(jdbcMaxActive));
        druidDataSource.setTestOnBorrow(true);
        druidDataSource.setInitialSize(Integer.parseInt(jdbcInitialSize));
        druidDataSource.setMinIdle(Integer.parseInt(jdbcMinIdle));
        druidDataSource.setMaxWait(Integer.parseInt(jdbcMaxWait));
        druidDataSource.setValidationQuery(jdbcValidationQuery);

        druidDataSource.setFilters("config");

//        ArrayList<Filter> filters = new ArrayList<>();
//        StatFilter statFilter = new StatFilter();
//        statFilter.setMergeSql(true);
//        statFilter.setSlowSqlMillis(1000);
//        statFilter.setLogSlowSql(true);
//        filters.add(statFilter);

//        LogFilter logFilter = new Slf4jLogFilter();
//        logFilter.setResultSetLogEnabled(false);
//        logFilter.setConnectionLogEnabled(false);
//        logFilter.setStatementCreateAfterLogEnabled(false);
//        filters.add(logFilter);
//
//        druidDataSource.setProxyFilters(filters);
        return druidDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        // 配置SQL耗时
        ArrayList<Interceptor> plugins = new ArrayList<>();
        plugins.add(new MybatisLogInterceptor());
        bean.setPlugins(plugins.toArray(new Interceptor[]{}));

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //每张表对应的xml文件
            bean.setMapperLocations(resolver.getResources("classpath:mappers/**/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
}
