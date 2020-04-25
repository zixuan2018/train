package com.example.train;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


import javax.sql.DataSource;
import java.util.Properties;


@Configuration
public class HibernateConfig {

    @Autowired
    private  Environment environment;



    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.example.train");//dao和entity的公共包
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        return sessionFactoryBean;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.current_session_context_class", environment.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.setProperty("hibernate.show-sql", environment.getProperty("spring.jpa.properties.hibernate.show-sql"));
        properties.setProperty("hibernate.cache.use_second_level_cache", environment.getProperty("spring.jpa.properties.hibernate.cache.use_second_level_cache"));
        properties.setProperty("hibernate.cache.use_query_cache", environment.getProperty("spring.jpa.properties.hibernate.cache.use_query_cache"));
        return properties;
               
    }


}
