package com.employee.model;

public class Employee
{

	private int empId;
	private String empName;
	private String email;
	private Double salary;
	private Double bonus;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getBonus() {
		return bonus;
	}
	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return "\nEmployee Details \n Employee Id : " + empId + "\n Employee Name : " + empName + 
				"\n Email Id : " + email + "\n Salary : " + salary
				+ "\n Bonus : " + bonus;
	}
	
	
	
	
}
