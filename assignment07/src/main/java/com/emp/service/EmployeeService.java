package com.emp.service;

import java.util.List;

import com.emp.pojos.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	String addNewEmployee(Employee employee);

	String deleteEmployee(Long empId);

	Employee getEmployeeDetails(Long empId);

	String updateEmployee(Long empId, Employee employee);
}
