package com.employee.dao;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeDao 
{
	
	public abstract void insertEmployee(Employee employee);
	public abstract Employee getEmployeeById(Integer empId);
	public abstract void updateEmpEmailById(String newEmail, Integer empId);
	public abstract void deleteEmpById(Integer empId);
	public abstract List<Employee> getAllEmpInfo();
	
}
