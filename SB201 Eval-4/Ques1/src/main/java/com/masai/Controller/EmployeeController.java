package com.masai.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.EmployeeDTO;
import com.masai.Exceptions.EmployeeException;
import com.masai.Service.EmployeeService;
import com.masai.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployeesDetails() throws EmployeeException {

		return new ResponseEntity<List<Employee>>(empService.getAllEmployeeDetails(), HttpStatus.OK);

	}

	

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) throws EmployeeException {

		return new ResponseEntity<Employee>(empService.registerEmployee(emp), HttpStatus.CREATED);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("empId") Integer empId,
			@Valid @RequestBody Employee emp) throws EmployeeException {

		return new ResponseEntity<Employee>(empService.updateEmployee(emp), HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Employee> delteEmployee(@PathVariable("emp") Integer empId) throws EmployeeException {

		return new ResponseEntity<Employee>(empService.deleteEmployeeById(empId), HttpStatus.CREATED);
	}
	
	@GetMapping("/employeebyaddress/{address}")
	public ResponseEntity<List<Employee>> getEmployeeByAddress(@PathVariable("address") String address) throws EmployeeException {

		List<Employee> emp = empService.getAllDetailsByAddress(address);
		
		return new ResponseEntity<List<Employee>>(emp, HttpStatus.OK);

	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getAll() throws EmployeeException {

		return new ResponseEntity<List<EmployeeDTO>>(empService.getNameAddressSalaryofAllEmployee(), HttpStatus.OK);
		

	}
    	
}