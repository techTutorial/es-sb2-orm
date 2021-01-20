package com.es.sb.mvc.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.es.sb.mvc.entity.UserEntity;


@Configuration
//@EnableTransactionManagement // not working
//@ComponentScans(value = { @ComponentScan("com.es.sb.mvc")})
public class HibernateConfig {

	//@Autowired
	//private ApplicationContext context;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//@Autowired
	//private DataSource dataSource;
	
	public HibernateConfig() { }
	
	@Bean
	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource());
			builder.scanPackages("com.es.sb.mvc");
			builder.addProperties(getHibernateProperties());
			//builder.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
			builder.addAnnotatedClasses(UserEntity.class); // optional
	        sessionFactory=builder.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	// useful in case of database connection and database connection via hibernate
	// in case of hibernate, not specifying dialect explicitly
    @Bean
    public DataSource getDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost:9001;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
    
    // useful in case of database connection via hibernate
    private final Properties getHibernateProperties() {
        Properties props = new Properties();
        props.setProperty("spring.jpa.database-platform", "org.hibernate.dialect.HSQLDialect");
        props.setProperty("spring.datasource.driver-class-name", "org.hsqldb.jdbcDriver");
        props.setProperty("spring.datasource.url", "jdbc:hsqldb:hsql://localhost:9001");
        props.setProperty("spring.datasource.username", "sa");
        props.setProperty("spring.datasource.password", "");
        props.setProperty("hibernate.show_sql", "true");
        //props.setProperty("hibernate.current_session_context_class", 
        		//"org.hibernate.context.internal.ThreadLocalSessionContext");
        //props.setProperty("hibernate.format_sql", "true");
        //props.setProperty("hibernate.use_sql_comments", "true");
        //props.setProperty("hibernate.hbm2ddl.auto", "create-drop"); // optional
        return props;
    }
    
    // not working
    /*@Bean
    public PlatformTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(((LocalSessionFactoryBean) getSessionFactory()).getObject());
        return transactionManager;
    }*/

}
