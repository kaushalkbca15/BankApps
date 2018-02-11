package com.fcb.persistence.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class FCBDataSource {
	@Bean
	public DataSource createDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@orcl:1521:orcl");
		dataSource.setUsername("FCBDB");
		dataSource.setPassword("fcbdb");
		System.out.println(dataSource);
		return dataSource;
	}
}
