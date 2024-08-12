package org.example.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    DataSource dataSource;
    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public DataSource dataSource(){
        try{
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2).addScripts("classpath:sql/schema.sql", "classpath:sql/test-data.sql").build();
        }catch (Exception e){
            logger.error("Embedded DataSource bean cannot be created", e);
            return null;
        }
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put(Environment.HBM2DDL_AUTO, "none");
        hibernateProp.put(Environment.FORMAT_SQL, false);
        hibernateProp.put(Environment.USE_SQL_COMMENTS, false);
        hibernateProp.put(Environment.SHOW_SQL, false);
        hibernateProp.put(Environment.MAX_FETCH_DEPTH, 3);
        hibernateProp.put(Environment.STATEMENT_BATCH_SIZE, 10);
        hibernateProp.put(Environment.STATEMENT_FETCH_SIZE, 50);
        return hibernateProp;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        var sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("org.example.entities");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException{
        return new HibernateTransactionManager((SessionFactory) sessionFactory());
    }
}
