package com.fcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fcb.service.AccountService;
import com.fcb.util.JSONUtile;
import com.fcb.utility.bean.DepositBean;
@RestController
public class AccountOperatoinController {

	@Autowired
	private AccountService accountSevice;
	
	@ResponseBody
	@RequestMapping(value="accountStatus",method=RequestMethod.GET)
	public String accountStatus(@RequestParam("accountNumber") String accountNumber) {
		String json=accountSevice.accountStatus(accountNumber);
		return json;
	}
	@ResponseBody
	@RequestMapping(value="balanceEnquiey",method=RequestMethod.GET)
	public String balanceEnquiry(@RequestParam("accountNumber") String accountNumber) {
		return 	accountSevice.getBalance(accountNumber);
	}
	@ResponseBody
	@RequestMapping(value="deposit",method=RequestMethod.POST)
	public String deposit(@RequestBody String jsonData) {
		String jsonResponce=null;
		if(jsonData!=null){
			DepositBean depositBean=JSONUtile.convertJsonToJava(DepositBean.class, jsonData);
			jsonResponce=accountSevice.deposit(depositBean);
		}
		return jsonResponce;
	}
	@ResponseBody
	@RequestMapping(value="withdraw",method=RequestMethod.POST)
	public String withdraw(@RequestBody String jsonData) {
		String jsonResponce=null;
		if(jsonData!=null){
			DepositBean depositBean=JSONUtile.convertJsonToJava(DepositBean.class, jsonData);
			jsonResponce=accountSevice.withdraw(depositBean);
		}
		return jsonResponce;
	}
	
	/**
	 * This method is use full getting all branch id 
	 * @return branch id
	 */
	
	@ResponseBody
	@RequestMapping(value="branchid",method=RequestMethod.GET)
	public String getBranchId(){
		String branchIdJson=null;
		branchIdJson=accountSevice.getbranchId();
		return branchIdJson;
	}
}
































