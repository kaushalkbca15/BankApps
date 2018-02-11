package com.fcb.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fcb.beans.AccountStatus;
import com.fcb.beans.FCBResponse;
import com.fcb.dao.AccountDAO;
import com.fcb.dao.CustomerDAO;
import com.fcb.entity.Account;
import com.fcb.entity.AccountTransactions;
import com.fcb.integration.FCBJavaEmail;
import com.fcb.integration.FCBSendSMS;
import com.fcb.util.DateConverter;
import com.fcb.util.FCBConstaint;
import com.fcb.util.FCBMessage;
import com.fcb.util.JSONUtile;
import com.fcb.utility.bean.DepositBean;
import com.sun.prism.impl.BaseMesh.FaceMembers;

@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger logger = Logger.getLogger(AccountServiceImpl.class);
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private CustomerDAO  customerDAO ;

	@Autowired
	private FCBJavaEmail fcbJavaEmail;
	@Autowired
	private FCBSendSMS fcbSendSMS;
	

	public String accountStatus(String accountNumber) {
		FCBResponse response = new FCBResponse();
		AccountStatus accountStatus = null;
		response.setMessage("Unable to process your request ! Please try again");
		response.setStatus(FCBConstaint.FCB_FAILURE);
		if (accountNumber != null && accountDAO != null) {
			try {
				accountStatus = accountDAO.accountStatus(Long.parseLong(accountNumber));
				if (accountStatus == null) {
						response.setStatus(FCBConstaint.FCB_FAILURE);
						response.setMessage("Invalied accoount number");
				} else {
					response.setData(accountStatus);
					response.setStatus(FCBConstaint.FCB_SUCCESS);
					response.setMessage("Account Details founds");
				}
			} catch (NumberFormatException e) {
				response.setMessage("Unable to process your request ! Please try again: " + e);
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Number formate ecception " + e);
			} catch (HibernateException e) {
				response.setMessage("Unable to process your request ! Please try again: " + e);
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exception occured while geting account status:" + e);
			} catch (Exception e) {e.printStackTrace();
				response.setMessage("Unable to process your request ! Please try again: " + e);
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exception occured while geting account status:" + e);
			}
		}
		return JSONUtile.convertJavaToJson(response);
	}

	/**
	 * This method is used for balance enquiry
	 * @param String account number  (String accountNumber)
	 * @return json data
	 */
	public String getBalance(String accountNumber) {
		FCBResponse response=new FCBResponse();
		Double balance=null;
		response.setStatus(FCBConstaint.FCB_FAILURE);
		response.setMessage("Unable to process your request ! Please try again :");
		if(accountNumber!=null && accountDAO!=null){
			try{
				balance=accountDAO.getBalance(Long.parseLong(accountNumber));
				if(balance==null){
					response.setMessage("Invalid account number");
					response.setStatus(FCBConstaint.FCB_FAILURE);
				}else{
					response.setData(balance);
					response.setMessage("balance found");
					response.setStatus(FCBConstaint.FCB_SUCCESS);
				}
			}catch (NumberFormatException e) {
				response.setMessage("Invalid account number: ");
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Error occure while geting balance :"+e);
			}catch (HibernateException e) {
				response.setMessage("Invalid account number: ");
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Error occure while geting balance :"+e);
			}catch (Exception e) {
				response.setMessage("Invalid account number: ");
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Error occure while geting balance :"+e);
			}
		}
		return JSONUtile.convertJavaToJson(response);
	}

	public String deposit(DepositBean depositBean) {
		String depositMessage="deposit";
		FCBResponse fcbResponse=new FCBResponse();
		fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
		fcbResponse.setMessage("Unable to process your request ! please try again:");
		
		if(depositBean!=null&&accountDAO!=null){
			AccountTransactions accountTransactions=new AccountTransactions();
			try{
				if((depositBean.getTransactionMode().equalsIgnoreCase("CHEQUE"))||(depositBean.getTransactionMode().equalsIgnoreCase("DD"))){
					accountTransactions.setChequeeOrddIssuedDate(DateConverter.setDate(depositBean.getIssuedDate()));
					accountTransactions.setChequeeOrddNumber(depositBean.getNumber().toString());
				}
				accountTransactions.setChequeeOrddIssuedBy(depositBean.getIssuedBy());
				accountTransactions.setTransactionMode(depositBean.getTransactionMode());

				accountTransactions.setTransactionAmount(depositBean.getAmount());
				accountTransactions.setTransactionStatus(FCBConstaint.FCB_SUCCESS);
				accountTransactions.setCreatedBy(1);
				accountTransactions.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				accountTransactions.setTransactionType("CR");
				accountTransactions.setTransactionDate(new Date());
				
				Account account=new Account();
				account.setAccountNumber(depositBean.getAccountNumber());
				account.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
				account.setBalance(depositBean.getAmount());
				account.setUpdatedBy(1);
				
				accountTransactions.setAccount(account);
				try{
					Integer trancetionId=accountDAO.deposit(account,accountTransactions);
					if(trancetionId==null){
						fcbResponse.setMessage("Unable to process your request ! please try again");
						fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
					}else{
						fcbResponse.setMessage(FCBMessage.getMessage(account,depositMessage)+",Transaction ID: "+trancetionId);
						fcbResponse.setStatus(FCBConstaint.FCB_SUCCESS);
						fcbResponse.setData(trancetionId);
					}
				}catch(Exception e){
					fcbResponse.setMessage("try once again !");
					fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
					logger.error("Exception occure while deposit amount :"+e);
				}
				//message
					Object[] objects=getCustomerDetails(account.getAccountNumber());
					
				if (objects[0] != null&&objects[0].toString().length()>0) {
					// email
					try {
						fcbJavaEmail.sendMail(objects[0].toString(), FCBMessage.getMessageSubject(), FCBMessage.getMessage(account,depositMessage));
						logger.info("Mail sended:");
					} catch (Exception e) {
						logger.error("Exception ouccure while sending mail " + e);
					}//catch
				}//if
				if(objects[1]!=null&&objects[1].toString().length()>0){
					//sms
					try{
						String smsResponce=fcbSendSMS.sendSMS(objects[1].toString(), FCBMessage.getMessage(account,depositMessage));
						logger.info("Sms sended "+smsResponce);
					}catch (Exception e) {
						logger.error("Exception occure while sending sms"+e);
					}
				}
			}catch (HibernateException e) {
				fcbResponse.setMessage("Unable to process your request ! please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exception occure while deposite: "+e);
			}catch (Exception e) {
				fcbResponse.setMessage("Unable to process your request ! please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exception occure while deposite: "+e);
			}
		}
		return JSONUtile.convertJavaToJson(fcbResponse);
	}
	
	private Object[] getCustomerDetails(Long accountNumber){
		Object[] customerDetails=null;
		FCBResponse  fcbResponse=new FCBResponse();
		fcbResponse.setMessage("Unable to process your request! Please try again");
		fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
		if(accountNumber!=null){
			try{
				 customerDetails=customerDAO.getCustomerDetails(accountNumber);
			}catch (HibernateException e) {
				logger.error("Exception occure while geting customer mobile number and email details+"+e);
				fcbResponse.setMessage("Unable to process your request! Please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
			}catch (Exception e) {
				logger.error("Exception occure while geting customer mobile number and email details+"+e);
				fcbResponse.setMessage("Unable to process your request! Please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
			}
		}
		return customerDetails;
	}
	/**
	 * This method is used for withdraw amount 
	 */
	public String withdraw(DepositBean depositBean) {
		String withdrowMessage="withdraw";
		FCBResponse fcbResponse=new FCBResponse();
		fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
		fcbResponse.setMessage("Unable to process your request ! please try again:");
		
		if(depositBean!=null&&accountDAO!=null){
			AccountTransactions accountTransactions=new AccountTransactions();
			try{
				if((depositBean.getTransactionMode().equalsIgnoreCase("CHEQUE"))||(depositBean.getTransactionMode().equalsIgnoreCase("DD"))){
					accountTransactions.setChequeeOrddIssuedDate(DateConverter.setDate(depositBean.getIssuedDate()));
					accountTransactions.setChequeeOrddNumber(depositBean.getNumber().toString());
				}
				accountTransactions.setChequeeOrddIssuedBy(depositBean.getIssuedBy());
				accountTransactions.setTransactionMode(depositBean.getTransactionMode());

				accountTransactions.setTransactionAmount(depositBean.getAmount());
				accountTransactions.setTransactionStatus(FCBConstaint.FCB_SUCCESS);
				accountTransactions.setCreatedBy(1);
				accountTransactions.setCreatedDate(new Timestamp(System.currentTimeMillis()));
				accountTransactions.setTransactionType("CR");
				accountTransactions.setTransactionDate(new Date());
				
				Account account=new Account();
				account.setAccountNumber(depositBean.getAccountNumber());
				account.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
				account.setBalance(depositBean.getAmount());
				account.setUpdatedBy(1);
				
				accountTransactions.setAccount(account);
				try {
					Integer trancetionId=accountDAO.withdraw(account, accountTransactions);
					if(trancetionId>0){
						fcbResponse.setData(trancetionId);
						fcbResponse.setMessage("Money has been withdrawn successfully");
						fcbResponse.setStatus(FCBConstaint.FCB_SUCCESS);
						logger.info("Money has been withdrawn successfully");
					}else{
						fcbResponse.setMessage("The amount entered is more than the amount balance");
						fcbResponse.setStatus(FCBConstaint.FCB_SUCCESS);
						logger.info("Money has been withdrawn successfully");
					}
				}catch (HibernateException e) {
					logger.error("Exception occure while withdraw money+"+e);
					fcbResponse.setMessage("Unable to process your request! Please try again");
					fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				}catch (Exception e) {
					logger.error("Exception occure while withdraw money+"+e);
					fcbResponse.setMessage("Unable to process your request! Please try again");
					fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				}
				//getting customer details
				Object []objects=null;
				try{
					objects=customerDAO.getCustomerDetails(account.getAccountNumber());
				}catch (Exception e) {
					logger.error("Exception occure while getting customer details+"+e);
					fcbResponse.setMessage("Unable to process your request! Please try again");
					fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				}
				//mail
				if(objects[0]!=null&&objects[0].toString().length()>0){
					try{
						fcbJavaEmail.sendMail(objects[0].toString(), FCBMessage.getMessageSubject(),FCBMessage.getMessage(account,withdrowMessage));
					}catch (Exception e) {
						logger.error("Exception occure while sending mail :+"+e);
					}
				}//if
				//sms
				if(objects[1]!=null&&objects.toString().length()>0){
					try{
						fcbSendSMS.sendSMS(objects[1].toString(), FCBMessage.getMessage(account,withdrowMessage));
					}catch (Exception e) {
						logger.error("Exception occure while sending sms :+"+e);
					}
				}
			} catch (NumberFormatException e) {
				logger.error("Exception occure while withdraw mony+"+e);
				fcbResponse.setMessage("Unable to process your request! Please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
			} catch (HibernateException e) {
				logger.error("Exception occure while withdraw mony+"+e);
				fcbResponse.setMessage("Unable to process your request! Please try again");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
			}//catch
		}//if
		return JSONUtile.convertJavaToJson(fcbResponse);
	}//withdraw

	/**
	 * This method is use full getting all branch id 
	 * @return branch id
	 */
	public String getbranchId() {
		List branchid=null;
		FCBResponse fcbResponse=new FCBResponse();
		fcbResponse.setMessage("Unable to procass getting branch id");
		fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
		if(accountDAO!=null){
			try{
				 branchid=accountDAO.getBranchId();
				 if(branchid==null){
					fcbResponse.setMessage("Unable to procass getting branch id Please try again");
					fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				 }else{
					 fcbResponse.setData(branchid);
					 fcbResponse.setStatus(FCBConstaint.FCB_SUCCESS);
					 fcbResponse.setMessage("selected branch id seccussfully ");
				 }
			}catch (HibernateException e) {
				fcbResponse.setMessage("Unable to procass getting branch id");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exceptoin occure while getting all branch id");
			}catch (Exception e) {
				fcbResponse.setMessage("Unable to procass getting branch id");
				fcbResponse.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exceptoin occure while getting all branch id");
			}//catch
		}//if
		String str=JSONUtile.convertJavaToJson(fcbResponse);
		return str;
	}
}
