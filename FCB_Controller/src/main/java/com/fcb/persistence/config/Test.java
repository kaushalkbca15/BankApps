package com.fcb.persistence.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test {
	

	
	public DataSource createDataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("PROJECT");
		dataSource.setPassword("project");
		System.out.println(dataSource);
		return dataSource;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PROJECT","project");
		String query = "select account_status from account where account_number=123456";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		System.out.println(rs);
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
	}

}
