package com.daos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.User;

public class UserDaoImpl extends Dao implements UserDao {

	private PreparedStatement stmtFindAll;
	private PreparedStatement stmtFindById;
	private PreparedStatement stmtFindByEmail;
	private PreparedStatement stmtSave;
	private PreparedStatement stmtUpdate;
	private PreparedStatement stmtDelete;

	public UserDaoImpl() throws Exception {

		String sqlFindAll = "SELECT * FROM users";
		stmtFindAll = con.prepareStatement(sqlFindAll);

		String sqlFindById = "SELECT * FROM users WHERE id =?";
		stmtFindById = con.prepareStatement(sqlFindById);

		String sqlFindByEamil = "SELECT * FROM users WHERE email=?";
		stmtFindByEmail = con.prepareStatement(sqlFindByEamil);

		String sqlSaveUser = "INSERT INTO users(first_name,last_name,email,password,dob,status,role) VALUES(?,?,?,?,?,?,?)";
		stmtSave = con.prepareStatement(sqlSaveUser);

		String sqlUpdate = "UPDATE users SET first_name = ? ,last_name = ?,email = ?,password = ?,dob=? ,status =?,role = ? WHERE id =?";
		stmtUpdate = con.prepareStatement(sqlUpdate);

		String sqlDelete = "DELETE FROM users WHERE id =?";
		stmtDelete = con.prepareStatement(sqlDelete);
	}

	@Override
	public void close() throws Exception {
		stmtFindAll.close();
		stmtFindById.close();
		stmtSave.close();
		stmtUpdate.close();
		stmtFindByEmail.close();
		super.close();
	}

	@Override
	public List<User> findAll() throws Exception {

		List<User> list = new ArrayList<User>();

		try (ResultSet rs = stmtFindAll.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date birth = rs.getDate("dob");
				int status = rs.getInt("status");
				String role = rs.getString("role");

				User u = new User(id, first_name, last_name, email, password, birth, status, role);

				list.add(u);
			}
		}

		return list;
	}

	@Override
	public User finduserById(int id) throws Exception {

		stmtFindById.setInt(1, id);

		try (ResultSet rs = stmtFindById.executeQuery();) {

			if (rs.next()) {
				id = rs.getInt("id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String email = rs.getString("email");
				String password = rs.getString("password");
				Date birth = rs.getDate("dob");
				int status = rs.getInt("status");
				String role = rs.getString("role");

				User u = new User(id, first_name, last_name, email, password, birth, status, role);

				return u;
			}

		} // rs.close()
		return null;
	}

	@Override
	public int saveUser(User u) throws Exception {

		stmtSave.setString(1, u.getFirst_name());
		stmtSave.setString(2, u.getLast_name());
		stmtSave.setString(3, u.getEmail());
		stmtSave.setString(4, u.getPassword());
		stmtSave.setDate(5, u.getDob());
		stmtSave.setInt(6, u.getStatus());
		stmtSave.setString(7, u.getRole());

		int count = stmtSave.executeUpdate();
		return count;
	}

	@Override
	public int updateUser(User u) throws Exception {

		stmtUpdate.setString(1, u.getFirst_name());
		stmtUpdate.setString(2, u.getLast_name());
		stmtUpdate.setString(3, u.getEmail());
		stmtUpdate.setString(4, u.getPassword());
		stmtUpdate.setDate(5, u.getDob());
		stmtUpdate.setInt(6, u.getStatus());
		stmtUpdate.setString(7, u.getRole());
		stmtUpdate.setInt(8, u.getId());

		int count = stmtUpdate.executeUpdate();

		return count;
	}

	@Override
	public int deleteUser(int id) throws Exception {

		stmtDelete.setInt(1, id);

		int count = stmtDelete.executeUpdate();

		return count;
	}

	@Override
	public User findByEmail(String email) throws Exception {
		stmtFindByEmail.setString(1, email);
		try (ResultSet rs = stmtFindByEmail.executeQuery()) {
			if (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				email = rs.getString("email");
				String password = rs.getString("password");
				Date birth = rs.getDate("dob");
				int status = rs.getInt("status");
				String role = rs.getString("role");
				User u = new User(id, firstName, lastName, email, password, birth, status, role);
				return u;
			}
		} // rs.close();
		return null;
	}

}
