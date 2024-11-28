package com.gajula.config;

import jakarta.persistence.PersistenceContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.gajula.repository",
  		entityManagerFactoryRef = "entityManagerFactoryBean",
		transactionManagerRef ="transactionManager")
public class PersistenceConfig {

	private final static Logger admin = LogManager.getLogger("admin");

	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriverClass;
	@Value("${gajula.pgdb.schema}")
	private String dbSchema;
	@Value("${spring.jpa.database-platform}")
	private String dbDialectClass;
	@Value("${gajula.pgdb.jta-platform}")
	private String dbJtaPlatform;
	@Value("${gajula.pgdb.jta-tx-factory}")
	private String dbJtatxfactory;
	@Value("${spring.jpa.show-sql}")
	private String dbShowSql;
	@Value("${gajula.pgdb.format-sql}")
	private String dbFormatSql;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String dbddlflag;
	@Value("${gajula.pgdb.contextClass}")
	private String dbContextClass;
	@Value("${gajula.pgdb.scan-package}")
	private String dbEntityscan;

	@Bean(name = "dataSource")
	public DataSource dataSource() throws Exception {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			dataSource.setUsername(dbUsername);
			dataSource.setPassword(dbPassword);
			dataSource.setUrl(dbUrl);
			dataSource.setDriverClassName(dbDriverClass);
			admin.debug("postgresql Database Connected:::");
			return dataSource;
		} catch (Exception e) {
			admin.error("ERROR OCCURED IN DATABASE AUTHENTICATION::::" + e.getMessage());
		}
		return dataSource;
	}

	private Properties jpaProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.dialect", dbDialectClass);
		prop.put("hibernate.hbm2ddl.auto", dbddlflag);
		prop.put("hibernate.show_sql", dbShowSql);
		prop.put("hibernate.format_sql", dbFormatSql);
		prop.put("hibernate.dafault-schema", dbSchema);
		prop.put("hibernate.transaction.jta.platform", dbJtaPlatform);
		prop.put("transaction.factory_class", dbJtatxfactory);
		prop.put("hibernate.order_by.default_null_ordering", "last");
		prop.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
		return prop;
	}

	@PersistenceContext(unitName = "gajulah2")
	@Bean(name = "entityManagerFactoryBean")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws Exception {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		try {
			em.setPersistenceUnitName("gajulah2");
			em.setDataSource(dataSource());
			em.setPackagesToScan(dbEntityscan);
			em.setJpaProperties(jpaProperties());
			em.setJpaVendorAdapter(vendorAdaptor());
			em.afterPropertiesSet();
			admin.info("configured Entity manager");
		}catch (Exception e) {
			admin.error("error while configuring entity manager"+e.getMessage());
		}
		return em;
	}
	
	@Bean(name="transactionManager")
	public PlatformTransactionManager transactionManager() throws Exception {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		admin.info("configured Transaction manager");
		return transactionManager;
	}

	private HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		return vendorAdapter;
	}
	
	@Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }

}
