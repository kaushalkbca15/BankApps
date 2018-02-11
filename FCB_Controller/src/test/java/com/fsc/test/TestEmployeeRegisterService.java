package com.fsc.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcb.config.RootConfig;
import com.fcb.service.EmployeeRegisterService;
import com.fcb.service.EmployeeRegisterServiceIpml;

import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class TestEmployeeRegisterService {
	
	@Autowired
	EmployeeRegisterServiceIpml employeeRegisterServiceIpml;

	@Test
	@Ignore
	public void testMaxEmployeeId(){
		System.out.println(employeeRegisterServiceIpml);
	//	assertNotEquals((Integer)101, employeeRegisterServiceIpml.getMaxEmployeeId());
	}
}
