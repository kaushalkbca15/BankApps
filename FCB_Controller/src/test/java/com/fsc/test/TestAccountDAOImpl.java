package com.fsc.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcb.config.RootConfig;
import com.fcb.dao.AccountDAO;

import jdk.nashorn.internal.ir.annotations.Ignore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class TestAccountDAOImpl {

	@Autowired
	private AccountDAO accountDAO;
	
	@Test
	@Ignore
	public void testBranchId(){
		assertNotEquals(null, accountDAO.getBranchId());
	}
}
