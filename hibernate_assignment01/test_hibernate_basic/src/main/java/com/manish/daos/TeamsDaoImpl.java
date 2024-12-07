package com.manish.daos;

import com.manish.entities.Teams;
import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeamsDaoImpl implements TeamsDao {

	@Override
	public String addUpTeam(Teams team) {

		String message = "Team Failed to add";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			Serializable teamId = session.save(team);

			tx.commit();
			message = "Team added Successfully...!";

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();

			throw e;
		}

		return message;
	}

}
