package com.masai.usecases;

import java.util.Scanner;

import com.masai.EmployeeBean.Employee;
import com.masai.EmployeeDao.EmployeeDao;
import com.masai.EmployeeDao.EmployeeDaoImpl;
import com.masai.EmployeeException.EmployeeException;

public class updateEmployee {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee id");
		int id = sc.nextInt();
		
		System.out.println("Enter Employee name");
		String name = sc.next();
		
		System.out.println("Enter Employee address");
		String addr = sc.next();
		
		System.out.println("Enter Employee salary");
		int sal = sc.nextInt();
		
		Employee emp = new Employee(id,name,addr,sal);
		
		EmployeeDao empDao = new EmployeeDaoImpl();
		
		try {
			
			empDao.updateEmployee(emp);
		}
		catch (EmployeeException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
}
