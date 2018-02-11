package com.fsc.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcb.config.RootConfig;
import com.fcb.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={RootConfig.class})
public class TestAccountServiceImpl {

	@Autowired
	private AccountService accountService;
	@Test
	@Ignore
	public void testBranchId(){
		assertNotEquals(null, accountService.getbranchId());
	}
}
