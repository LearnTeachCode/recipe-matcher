package devApp.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.apache.commons.dbcp.BasicDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "devApp" })
public class PersistenceConfig {
 
   @Autowired
   private Environment env;
 
   @Bean(name="sessionFactory")
   public LocalSessionFactoryBean sessionFactory() {
      final LocalSessionFactoryBean sessionFactory =
              new LocalSessionFactoryBean();
      sessionFactory
              .setDataSource(restDataSource());
      sessionFactory
              .setPackagesToScan("devApp");
      sessionFactory
              .setHibernateProperties(hibernateProperties());
      return sessionFactory;
   }
 
   @Bean
   public DataSource restDataSource() {
      final BasicDataSource dataSource =
              new BasicDataSource();
      dataSource.setDriverClassName(
              this.env.getProperty("hibernate.driver.name"));
      dataSource.setUrl(
              this.env.getProperty("spring.datasource.url"));
      dataSource.setUsername(
              this.env.getProperty("spring.datasource.username"));
      dataSource.setPassword(
              this.env.getProperty("spring.datasource.password"));
      return dataSource;
   }
 
   @Bean
   @Autowired
   public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
      final HibernateTransactionManager txManager =
              new HibernateTransactionManager();
      txManager.setSessionFactory(sessionFactory);
      return txManager;
   }
 
   @Bean
   public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
      return new PersistenceExceptionTranslationPostProcessor();
   }
 
   private Properties hibernateProperties() {
       return new Properties() {
		private static final long serialVersionUID = 1L;
           {
            setProperty("hibernate.hbm2ddl.auto",
                    env.getProperty("hibernate.hbm2ddl.auto"));
            setProperty("hibernate.show_sql",
                    env.getProperty("hibernate.show_sql"));
            setProperty("hibernate.dialect",
                    env.getProperty("hibernate.dialect"));
            setProperty("hibernate.globally_quoted_identifiers",
                    env.getProperty("hibernate.globally_quoted_identifiers"));
           }
       };
   }
}
