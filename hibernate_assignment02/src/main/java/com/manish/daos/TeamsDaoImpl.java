package com.manish.daos;

import com.manish.entities.Teams;
import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

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

	@Override
	public List<Teams> getAllTeams() {

		String jpql = "select t from Teams t";

		List<Teams> team = null;

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			team = session.createQuery(jpql, Teams.class).getResultList();

			tx.commit();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			throw e;
		}

		return team;
	}

	@Override
	public List<Teams> getAllSelectedTeam(int age, double avg) {

		List<Teams> team = null;

		String jqpl = "select t from Teams t where t.maxPlayerAge<:ag and t.battingAvg>:bat";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			team = session.createQuery(jqpl, Teams.class).setParameter("ag", age).setParameter("bat", avg)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			throw e;
		}

		return team;
	}

	@Override
	public List<Teams> displayOwnerNameAndAbbreviations(int age, double avg) {

		List<Teams> teams = null;

		String jpql = "select new com.manish.entities.Teams(owner,abbreviation) from Teams t where t.maxPlayerAge<:age and t.battingAvg>:average";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			teams = session.createQuery(jpql, Teams.class).setParameter("age", age).setParameter("average", avg)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return teams;
	}

	@Override
	public String deleteTeamDetails(Long teamId) {

		String mesg = "Deletion failed!!!!!!";
		Teams team = null;
		Session session = getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			// get
			team = session.get(Teams.class, teamId);
			if (team != null) {
				// user - persistent
				session.delete(team);
				mesg = "deleted team Success!";
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

	@Override
	public String updateMaxPlayerAge(String tName, int mAge) {

		String mesg = "team update to failed";
		Teams team = null;
		String jpql = "select t from Teams t where t.name=:tName";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			team = session.createQuery(jpql, Teams.class).setParameter("tName", tName).getSingleResult();
			team.setMaxPlayerAge(mAge);
			mesg = "team Succesfully updated";

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();

			throw e;
		}

		return mesg;
	}

}
