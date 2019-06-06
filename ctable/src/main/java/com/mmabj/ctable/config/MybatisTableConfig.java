package com.mmabj.ctable.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;



/**
 * @author  
 * @date 2017/11/14
 */
@Configuration
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*"})
public class MybatisTableConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${mybatis.mapper-locations}")
    private String[] mapperLocations;

    @Bean
    public PropertiesFactoryBean configProperties() throws Exception{
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        propertiesFactoryBean.setLocations(resolver.getResources("classpath*:application.properties"));
        return propertiesFactoryBean;
    }
    //配置参数
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(30);
        dataSource.setInitialSize(10);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setQueryTimeout(10);
        return dataSource;
    }

//    druid.query-timeout=10
//    druid.transaction-query-timeout=20
//    druid.kill-when-socket-read-timeout=true
//    druid.test-while-idle=true
//    druid.initial-size=1
//    druid.max-active=20
//    druid.min-idle=1
//    druid.max-wait=60000
//    druid.validation-query=SELECT 'x'
//    druid.pool-prepared-statements=true
//    druid.max-open-prepared-statements=20
//    druid.time-between-eviction-runs-millis=60000
//    druid.min-evictable-idle-time-millis=300000
//    druid.filters=stat
//    druid.filter.stat.log-slow-sql=false
//    druid.filter.stat.slow-sql-millis=2000
//    druid.stat-view-servlet.enabled=true
//    druid.stat-view-servlet.url-pattern=/druid/*
//     druid.stat-view-servlet.reset-enable=true
//      druid.stat-view-servlet.login-username=admin
//      druid.stat-view-servlet.login-password=admin






    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());
        return dataSourceTransactionManager;
    }
//配置mapperxml位置
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources1 = resolver.getResources("classpath*:com/gitee/sunchenbin/mybatis/actable/mapping/*/*.xml");
        String path="classpath*:mapper/*.xml";
        if(mapperLocations!=null){
            path=mapperLocations[0].substring(2,mapperLocations[0].length()-1);
        }
        Resource[] resources2 = resolver.getResources(path);
        int count=resources1.length+resources2.length;
        Resource[] resources= new Resource[count];
        int i=0;
        for (Resource resource : resources1) {
            resources[i]=resource;
            i++;
        }
        for (Resource resource : resources2) {
            resources[i]=resource;
            i++;
        }
        sqlSessionFactoryBean.setMapperLocations(resources);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.mmabj.ctable.entity.*");
        return sqlSessionFactoryBean;
    }

}