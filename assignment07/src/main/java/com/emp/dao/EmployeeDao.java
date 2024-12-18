package com.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
