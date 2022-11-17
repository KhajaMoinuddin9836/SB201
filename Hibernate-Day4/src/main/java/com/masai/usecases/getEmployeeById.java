package com.masai.usecases;

import java.util.Scanner;

import com.masai.EmployeeDao.EmployeeDao;
import com.masai.EmployeeDao.EmployeeDaoImpl;
import com.masai.EmployeeException.EmployeeException;

public class getEmployeeById {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee id");
		int id = sc.nextInt();
		
		EmployeeDao empDao = new EmployeeDaoImpl();
		
		try {
			
			empDao.getEmployeeById(id);
		}
		catch (EmployeeException e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
