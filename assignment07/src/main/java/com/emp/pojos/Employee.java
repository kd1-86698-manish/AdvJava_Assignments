package com.emp.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Employee extends BaseClass {

	@Column(name = "first_name", length = 30)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;

	@Column(length = 30, unique = true)
	private String email;

	@Column(length = 30)
	private String password;

	@Column(name = "join_date", length = 30)
	private LocalDate joinDate;

	@Column(length = 30)
	private String location;

	@Column(length = 30)
	private String department;

	private double salary;

	public Employee(String firstName, String lastName, String email, String password, LocalDate joinDate,
			String location, String department, double salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.joinDate = joinDate;
		this.location = location;
		this.department = department;
		this.salary = salary;
	}

}
