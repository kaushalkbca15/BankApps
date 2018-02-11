package com.fsc.test;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcb.config.RootConfig;
import com.fcb.dao.EmployeeDAO;
import com.fcb.integration.FCBSendSMS;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class TestFCBDAO {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Test
	public void getEmployeeID(){
		Integer id=101;
		assertNotEquals(id,employeeDAO.getMaxEmployeeId());
	}
}
