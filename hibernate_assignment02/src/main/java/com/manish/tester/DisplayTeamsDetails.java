package com.manish.tester;

import org.hibernate.SessionFactory;

import com.manish.daos.TeamsDao;
import com.manish.daos.TeamsDaoImpl;

import static com.manish.utils.HibernateUtils.getSessionFactory;

public class DisplayTeamsDetails {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory()) {

			TeamsDao teamDao = new TeamsDaoImpl();
			teamDao.getAllTeams().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
