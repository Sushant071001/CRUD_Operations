package com.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.database.connection.util.DBUtil;
import com.employee.dao.EmployeeDao;
import com.employee.model.Employee;

public class EmployeeImpl implements EmployeeDao
{
	
	DBUtil dbutil = new DBUtil();
	
	@Override
	public void insertEmployee(Employee employee) 
	{
		String query = "INSERT INTO employee(emp_id, emp_name, email, salary, bonus)"
				+ "VALUES(?,?,?,?,?)";
		try(Connection connection = dbutil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setInt(1, employee.getEmpId());
			ps.setString(2, employee.getEmpName());
			ps.setString(3, employee.getEmail());
			ps.setDouble(4, employee.getSalary());
			ps.setDouble(5, employee.getBonus());
			
			int exe = ps.executeUpdate();
			
			if(exe==1)
			{
				System.out.println(exe+" record inserted\n");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Employee getEmployeeById(Integer empId) 
	{
		Employee employee = null;
		String query = "select * from employee where emp_id = ?";
		try(Connection connection = dbutil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				int eid = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				Double bonus = rs.getDouble("bonus");
				
				employee = new Employee();
				employee.setBonus(bonus);
				employee.setEmail(email);
				employee.setEmpId(eid);
				employee.setEmpName(empName);
				employee.setSalary(salary);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void updateEmpEmailById(String newEmail, Integer empId) 
	{
		String query = "update employee set email = ? where emp_id = ?";
		try(Connection connection = dbutil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setString(1, newEmail);
			ps.setInt(2, empId);
			
			int exe = ps.executeUpdate();
			
			if(exe==1)
			{
				System.out.println(exe+" record updated\n");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmpById(Integer empId) 
	{
		String query = "delete from employee where emp_id = ?";
		try(Connection connection = dbutil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);)
		{
			ps.setInt(1, empId);
			
			int exe = ps.executeUpdate();
			
			if(exe==1)
			{
				System.out.println(exe+" record deleted\n");
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> getAllEmpInfo()
	{
//		Employee employee = null;
		List<Employee> empList = new ArrayList<Employee>();
		String query = "select * from employee";
		try(Connection connection = dbutil.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);)
		{
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int eid = rs.getInt("emp_id");
				String empName = rs.getString("emp_name");
				String email = rs.getString("email");
				Double salary = rs.getDouble("salary");
				Double bonus = rs.getDouble("bonus");
				
				Employee employee = new Employee();
				employee.setBonus(bonus);
				employee.setEmail(email);
				employee.setEmpId(eid);
				employee.setEmpName(empName);
				employee.setSalary(salary);
				empList.add(employee);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return empList;
	}

}
