package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emp.dao.EmployeeDao;
import com.emp.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public String addNewEmployee(Employee employee) {

		Employee persist = employeeDao.save(employee);
		return "Added new Employee with ID " + persist.getId();
	}

	@Override
	public String deleteEmployee(Long empId) {

		if (employeeDao.existsById(empId))

		{
			employeeDao.deleteById(empId);
			return "Deleted employee";
		}
		return "Invalid employee id";
	}

	@Override
	public Employee getEmployeeDetails(Long empId) {

		return employeeDao.findById(empId).orElseThrow(() -> new RuntimeException("Invalid category id"));
	}

	@Override
	public String updateEmployee(Long empId, Employee employee) {
		if (employeeDao.existsById(empId)) {
			employee.setId(empId);
			employeeDao.save(employee);
			return "Employee Updated";
		}

		return "Invalid Employee Id";
	}

}
