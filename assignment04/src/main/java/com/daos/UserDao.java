package com.daos;

import java.util.List;

import com.entities.User;

public interface UserDao extends AutoCloseable {

	List<User> findAll() throws Exception;

	User finduserById(int id) throws Exception;

	User findByEmail(String email) throws Exception;

	int saveUser(User u) throws Exception;

	int updateUser(User u) throws Exception;

	int deleteUser(int id) throws Exception;

}
