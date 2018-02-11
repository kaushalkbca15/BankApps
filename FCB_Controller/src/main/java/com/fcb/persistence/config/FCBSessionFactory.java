package com.fcb.persistence.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.fcb.entity.Account;
import com.fcb.entity.AccountServices;
import com.fcb.entity.AccountTransactions;
import com.fcb.entity.AccountType;
import com.fcb.entity.AddressProof;
import com.fcb.entity.Bank;
import com.fcb.entity.Branch;
import com.fcb.entity.Card;
import com.fcb.entity.CardType;
import com.fcb.entity.Customer;
import com.fcb.entity.Days;
import com.fcb.entity.EducationalDetails;
import com.fcb.entity.Employee;
import com.fcb.entity.IdentificationProof;
import com.fcb.entity.Loan;
import com.fcb.entity.LoanType;
import com.fcb.entity.Nominee;
import com.fcb.entity.OtherIdCard;
import com.fcb.entity.PassportDetails;
import com.fcb.entity.PaymentSystem;
import com.fcb.entity.PermanentAddress;
import com.fcb.entity.PresentAddress;
import com.fcb.entity.Time;
import com.fcb.entity.UserAuthentication;
import com.fcb.entity.UserAuthorization;
import com.fcb.entity.WorkingHours;

@Configuration
@ComponentScan(basePackages="com.fcb.dao")
@Import(value=FCBDataSource.class)
//@EnableCaching
public class FCBSessionFactory {

	@Autowired
	private DataSource dataSource;
	

	@Bean
	public LocalSessionFactoryBean crateSessionFactory() {
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setHibernateProperties(getProperty());
		bean.setAnnotatedClasses(Account.class,Branch.class,AccountType.class,Customer.class,Employee.class,IdentificationProof.class,OtherIdCard.class,PermanentAddress.class,PresentAddress.class,PassportDetails.class,Nominee.class,Bank.class,AccountTransactions.class,WorkingHours.class,Days.class,Time.class,UserAuthentication.class,UserAuthorization.class,EducationalDetails.class,AccountServices.class,Card.class,CardType.class,Loan.class,LoanType.class,AddressProof.class,PaymentSystem.class);
		return bean;
	}
	private Properties getProperty() {
		Properties properties=new  Properties();
		properties.setProperty("show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.cache.use_second_level_cache","true");
		properties.setProperty("hibernate.cache.use_second_level_cache", "org.hibernate.cache.ehcache.EhCacheRegionFactor");
		//properties.setProperty("hibernate.cache.use_query_cache", "true");
		properties.setProperty("net.sf.ehcache.configurationResourceName", "ehcache.xml");
		return properties;
	}
	
}
