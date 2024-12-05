package com.beans;

import java.sql.Date;

import com.daos.UserDao;
import com.daos.UserDaoImpl;
import com.entities.User;

public class RegisterBean {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	private int status;
	private String role;
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public RegisterBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void register() {

		Date dob = Date.valueOf(birth);

		User u = new User(0, firstName, lastName, email, password, dob, 0, "voter");

		try (UserDao userDao = new UserDaoImpl()) {

			int cnt = userDao.saveUser(u);
			System.out.println(cnt);
			if (cnt == 1) {
				count = cnt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
