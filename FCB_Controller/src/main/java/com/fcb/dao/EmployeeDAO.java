package com.fcb.dao;

import java.util.List;

import com.fcb.entity.Employee;

public interface EmployeeDAO {
	public Integer registerEmployee(Employee employee,Integer branchID);

	public Integer getMaxEmployeeId();
}
