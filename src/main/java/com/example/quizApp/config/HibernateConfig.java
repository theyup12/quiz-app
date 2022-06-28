package com.example.quizApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConfig {
    @Autowired
    HibernateDbProperty hibernateDbProperty;

    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.quizApp.entity");
        sessionFactory.setHibernateProperties(createHibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(hibernateDbProperty.getDriver());
        dataSource.setUrl(hibernateDbProperty.getUrl());
        dataSource.setUsername(hibernateDbProperty.getUsername());
        dataSource.setPassword(hibernateDbProperty.getPassword());

        return dataSource;
    }
    @Bean
    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
    private final Properties createHibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.show_sql", hibernateDbProperty.getShowSql());
        hibernateProperties.setProperty("hibernate.dialect", hibernateDbProperty.getDialect());

        return hibernateProperties;
    }
}
