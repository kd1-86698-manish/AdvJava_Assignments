package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.pojos.Employee;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		System.out.println("in ctor " + getClass());
	}

	@GetMapping("/")
	public ResponseEntity<?> getEmployee() {

		List<Employee> employees = employeeService.getAllEmployee();

		if (employees.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		return ResponseEntity.ok(employees);
	}

	@PostMapping("/")
	public ResponseEntity<?> addNewEmployee(@RequestBody Employee employee) {

		System.out.println("in add new Employee");

		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addNewEmployee(employee));

	}

	@GetMapping("/{empId}")
	public ResponseEntity<?> getEmpDetail(@PathVariable Long empId) {
		System.out.println("in get details");

		try {

			Employee employee = employeeService.getEmployeeDetails(empId);
			return ResponseEntity.ok(employee);

		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee Notfound");
		}
	}

	@PutMapping("/{empId}")
	public ResponseEntity<?> updateEmpDetail(@PathVariable Long empId, @RequestBody Employee employee) {

		System.out.println("in update ctor " + empId + " " + employee);

		return ResponseEntity.ok(employeeService.updateEmployee(empId, employee));

	}

	@DeleteMapping("/{empId}")
	public ResponseEntity<?> deleteEmployeeDetails(@PathVariable Long empId) {

		System.out.println("in delete " + empId);

		try {

			return ResponseEntity.ok(employeeService.deleteEmployee(empId));

		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee delete succesfully");

		}

	}

}
