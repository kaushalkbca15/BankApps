package com.fcb.dao;

import java.math.BigDecimal;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fcb.entity.Branch;
import com.fcb.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	/**
	 * This method is use for register employee
	 * @param employee ,branch id
	 * @return employee Id
	 */
	public Integer registerEmployee(Employee employee, Integer branchId) {
		Integer employeeId = null;
		if (sessionFactory != null && employee != null) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			if (session != null && tx != null) {
				try {
					Branch Branch = (Branch) session.get(Branch.class, branchId);
					
					Set<Employee> employeeSet = Branch.getEmployee();
					
					employeeSet.add(employee);
					employeeId = (Integer) session.save(Branch);
					
					if (employeeId == null) {
						logger.error("Exception ouucre while register employee ");
						tx.rollback();
					} else {
						tx.commit();
						logger.info("Employee register successfully Id :" + employeeId);
					}
				} finally {
					try {
						session.close();
					} catch (Exception e) {
						employeeId=null;
						tx.rollback();
						logger.error("Exception occure while closing session : "+e);
					}//catch
				}//finally
			}//if

		}//if
		return employeeId;
	}//method

	public Integer getMaxEmployeeId() {
		String hql_query_select_max_id="select max(EMPLOYEE_ID) from Employee";
		Integer employeeId = null;
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			if (session != null && tx != null) {
				try {
					BigDecimal bigDecimal= (BigDecimal) session.createSQLQuery(hql_query_select_max_id).uniqueResult();
					employeeId=bigDecimal.intValue();
					if (employeeId == null) {
						logger.error("Exception ouucre while geting  employee Id ");
						tx.rollback();
					} else {
						tx.commit();
						logger.info("Employee  Id :" + employeeId);
					}
				} finally {
					try {
						session.close();
					} catch (Exception e) {
						employeeId=null;
						tx.rollback();
						logger.error("Exception occure while closing session : "+e);
					}//catch
				}//finally
			}//if

		}//if
		return employeeId;
	}
}//class
