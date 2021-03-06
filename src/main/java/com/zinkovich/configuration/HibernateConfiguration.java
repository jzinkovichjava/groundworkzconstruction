package com.zinkovich.configuration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.zinkovich.config" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.zinkovich.domain" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        if(System.getenv("OPENSHIFT_MYSQL_DB_HOST") != null) {
            String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            String name = System.getenv("OPENSHIFT_APP_NAME");
            dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + name);
            dataSource.setUsername(System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"));
            dataSource.setPassword(System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));
        } else {
            String host = "127.0.0.1"; //System.getenv("OPENSHIFT_MYSQL_DB_HOST");
            String port = "3306";//System.getenv("OPENSHIFT_MYSQL_DB_PORT");
            String name = "tomcatapp"; //System.getenv("OPENSHIFT_APP_NAME");
            dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + name);
            dataSource.setUsername("adminKDzXrTR");//System.getenv("OPENSHIFT_MYSQL_DB_USERNAME"));
            dataSource.setPassword("K44a6EqeU5EH");//System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD"));
        }

            return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}