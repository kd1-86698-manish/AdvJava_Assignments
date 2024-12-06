package com.beans;

import com.daos.CandidateDao;
import com.daos.CandidateDaoImpl;
import com.daos.UserDao;
import com.daos.UserDaoImpl;
import com.entities.User;

public class VoteBean {

	private int candId;
	private boolean success;
	private int userId;

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}


	public VoteBean() {
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void vote() {

		this.success = false;

		try (CandidateDao candDao = new CandidateDaoImpl()) {

			int count = candDao.incrVote(this.candId);

			if (count == 1) {
				try (UserDao userDao = new UserDaoImpl()) {

					User user = userDao.finduserById(this.userId);

					if (user != null) {

						user.setStatus(1);
						count = userDao.updateUser(user);

						if (count == 1)
							this.success = true;
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}
