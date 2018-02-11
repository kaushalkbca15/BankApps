package com.fcb.dao;




import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fcb.beans.AccountStatus;
import com.fcb.entity.Account;
import com.fcb.entity.AccountTransactions;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory factory;
	
	private static Logger logger = Logger.getLogger(AccountDAOImpl.class);
	
	private static final String SQL_QUERY_SELECTBALANCE="SELECT balance FROM Account WHERE accountNumber=?";
	private static final String HQL_QUERY_UPDATE_ACCOUNT_DEPOSIT="UPDATE Account set balance=balance+? ,updatedBy=?,updatedDate=? where accountNumber=?";
	private static final String HQL_QUERY_UPDATE_ACCOUNT_WITHDRAW="UPDATE Account set balance=balance-? ,updatedBy=?,updatedDate=? where accountNumber=?";
	public AccountStatus accountStatus(Long accountNumber) {
		AccountStatus accountStatus = null;
		if (accountNumber != null && factory != null) {
			Session session = factory.openSession();
			if (session != null) {
				try {
					Criteria criteria = session.createCriteria(Account.class).createAlias("branch", "branch")
							.add(Restrictions.eq("accountNumber", accountNumber))
							.setProjection(Projections.projectionList()
									.add(Projections.property("accountNumber"), "accountNumber")
									.add(Projections.property("accountHolderName"), "accountHolderName")
									.add(Projections.property("accountStatus"), "accountStatus")
									.add(Projections.property("branch.branchName"), "branchName"))
							.setResultTransformer(Transformers.aliasToBean(AccountStatus.class));
					accountStatus = (AccountStatus) criteria.uniqueResult();
				}
				finally {
					try {
						session.close();
					} catch (Exception e) {
						logger.error("Exception occures while closeing session: " + e);
					}
				}
			}

		}
		return accountStatus;
	}
	/**
	 * This method is used for getting balance account from DB table
	 * @param Long account number
	 * @return Long 
	 */
	public Double getBalance(Long accountNumber) {
		Double balance=null;
		if(accountNumber!=null&&factory!=null){
			Session session=factory.openSession();
			if(session!=null){
				try{
					balance=(Double) session.createQuery(SQL_QUERY_SELECTBALANCE)
							.setParameter(0,accountNumber)
							.uniqueResult();
				}finally {
					try{
						session.close();
					}catch (Exception e) {
						logger.error("Exception occure while closing session: "+e);
					}//catch
				}//finally
			}//if
		}//if
		
		return balance;
	}
	/**
	 * This method is used for deposit balance from accountTranceation DB table and
	 *  Update amount Account DB table
	 *  @return return type Integer,return trancationId
	 *  @param Account object and AccountTrancation object
	 */
	public Integer deposit(Account account, AccountTransactions accountTransactions) {
		Integer transactionId=null;
		int count=0;
		if(account!=null&&accountTransactions!=null&&factory!=null){
			Session session=factory.openSession();
			if(session!=null){
				Transaction transaction=null;
				try{
					transaction=session.beginTransaction();
					transactionId=(Integer)session.save(accountTransactions);
					if(transactionId!=null && transactionId>0){
						count=session.createQuery(HQL_QUERY_UPDATE_ACCOUNT_DEPOSIT)
						.setParameter(0, account.getBalance())
						.setParameter(1, account.getUpdatedBy())
						.setParameter(2, account.getUpdatedDate())
						.setParameter(3, account.getAccountNumber())
						.executeUpdate();
						if(count>0){
							transaction.commit();
						}else{
							transaction.rollback();
							transactionId=0;
						}//else
					}//if
					else{
						transaction.rollback();
						transactionId=0;
					}
				}catch (Exception e) {
					if(transaction!=null){
						transaction.rollback();
						transactionId=0;
					}
					
				}finally {
					try{
						session.close();
					}catch (Exception e) {
						logger.error("Exception occure while closing session :" +e);
					}
				}
			}//if
		}//if
		return transactionId;
	}
	public Integer withdraw(Account account, AccountTransactions accountTransactions) {
		Integer transactionId=null;
		int count=0;
			if(account!=null&&accountTransactions!=null&&factory!=null){
				Session session=factory.openSession();
				String HQL_QUERY_SELECTBALANCE="select balance from Account where accountNumber=?";
				if(session!=null){
					Transaction tx=null;
					try{
						tx=session.beginTransaction();
						transactionId=(Integer)session.save(accountTransactions);
						if(transactionId!=null&&transactionId.toString().length()>0){
						
						Double current_balance=(Double) session.createQuery(HQL_QUERY_SELECTBALANCE)
								.setParameter(0, account.getAccountNumber())
								.uniqueResult();
							if(current_balance!=null&&current_balance.toString().length()>0&&current_balance>account.getBalance()){
								count=session.createQuery(HQL_QUERY_UPDATE_ACCOUNT_WITHDRAW)
										.setParameter(0, account.getBalance())
										.setParameter(1, account.getUpdatedBy())
										.setParameter(2, account.getUpdatedDate())
										.setParameter(3, account.getAccountNumber())
										.executeUpdate();
								if(count>0){
									tx.commit();
								}else{
									tx.rollback();
									transactionId=0;
								}
							}else{
								tx.rollback();
								transactionId=0;
							}
						}
						else{
							tx.rollback();
							transactionId=0;
						}						
					}finally{
						try{
							session.close();
						}catch (Exception e) {
							logger.error("Exception occure while closing session:"+e);
						}
					}
				}//if
			}//if
		return transactionId;
	}
	/**
	 * This method is use full getting all branch id 
	 * @return branch id
	 */
	 private static final String HQL_QUERY_SELECT_ALL_BRANCHID="select branchId from Branch";
	public List getBranchId() {
		List branchId=null;
		if(factory!=null){
			Session session=factory.openSession();
			if(session!=null){
				try{
					branchId =session.createQuery(HQL_QUERY_SELECT_ALL_BRANCHID).list();
				}finally {
					try{
						session.close();
					}catch (Exception e) {
						logger.error("Exception occure while closingr session ");
					}//catch
				}//finally
			}//if
		}//if
		return branchId;
	}

}
