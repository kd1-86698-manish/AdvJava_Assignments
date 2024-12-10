package com.manish.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.manish.entities.Players;
import com.manish.entities.Teams;

import static com.manish.utils.HibernateUtils.getSessionFactory;

public class PlayersDaoImpl implements PlayersDao {

	@Override
	public String addPlayer(Long teamId, Players player) {

		String mesge = "Player failed to add";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			Teams team = session.get(Teams.class, teamId);

			if (team != null) {

				team.addNewPlayer(player);
				session.persist(player);
			}

			tx.commit();
			mesge = "new player added " + player.getId();

		} catch (RuntimeException e) {

			if (tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}

		return mesge;
	}

	@Override
	public String removePlayer(Long teamId, Long playerId) {

		String mesg = "Removing player failed...";

		Session session = getSessionFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			Teams team = session.get(Teams.class, playerId);

			Players players = session.get(Players.class, playerId);

			if (team != null && players != null) {
				team.removePlayer(players);
			}
			tx.commit();
			mesg = "Removing Player Successfull..";

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return mesg;
	}

}
