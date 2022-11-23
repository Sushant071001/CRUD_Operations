package com.main;

import java.util.List;
import java.util.Scanner;

import com.employee.dao.EmployeeDao;
import com.employee.dao.impl.EmployeeImpl;
import com.employee.model.Employee;

public abstract class TestMain
{
	
	// Global object class creation.
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		
		EmployeeDao employeeDao = new EmployeeImpl();
		
		while (true)
		{
			System.out.println("***********************************");
			System.out.println("1. Insert data");
			System.out.println("2. Show Employee details by Emp_Id");
			System.out.println("3. Update Email by Emp_Id");
			System.out.println("4. Delete Employee by Emp_Id");
			System.out.println("5. Get all Employee info");
			System.out.println("6. Exit");
			System.out.println("***********************************");
			System.out.println();
			
			System.out.print("Please Enter Your choice : ");
			int choice = sc.nextInt();
			System.out.println();
			
			if(choice==1)
			{
				getEmployee();
			}
			else if(choice==2)
			{
				getEmpById(employeeDao);
			}
			else if (choice==3) 
			{
				System.out.print("Enter id to update Email : ");
				int empId = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter New email Id : ");
				String newEmail = sc.nextLine();
				employeeDao.updateEmpEmailById(newEmail, empId);
			}
			else if (choice==4) 	
			{
				System.out.print("Enter Id : ");
				int empId = sc.nextInt();
				sc.nextLine();
				employeeDao.deleteEmpById(empId);
			}
			else if (choice==5) 	
			{
				List<Employee> empList = employeeDao.getAllEmpInfo();
				empList.forEach(System.out::println);
			}
			else if (choice==6) 	
			{
				System.exit(0);
			}
			else
			{
				System.err.println("Please Enter Correct Choice between 1 to 5 ");
				System.out.println();
			}
		}			
		
	}

	private static Employee getEmployee()
	{
		Employee employee = new Employee();
		EmployeeDao employeeDao = new EmployeeImpl();
		
		System.out.print("Enter Employee Id : ");
		int id = sc.nextInt();
		sc.nextLine();
		employee.setEmpId(id);
		
		System.out.print("Enter Employee Name : ");
		String name = sc.nextLine();
		employee.setEmpName(name);
		
		System.out.print("Enter Employee Email : ");
		String email = sc.nextLine();
		employee.setEmail(email);
		
		System.out.print("Enter Employee Salary : ");
		Double salary = sc.nextDouble();
		employee.setSalary(salary);
		
		System.out.print("Enter Employee Bonus : ");
		Double bonus = sc.nextDouble();
		employee.setBonus(bonus);
		
		employeeDao.insertEmployee(employee);
		return employee;
	}

	private static void getEmpById(EmployeeDao employeeDao)
	{
		System.out.print("Enter empid to see details : ");
		int n = sc.nextInt();
		Employee employee2 = employeeDao.getEmployeeById(n);
		if(employee2!=null)
		{
			System.out.println(employee2);
		}
		else {
			System.err.println("\nEmployee does not exists\n");
		}		
	}

}










