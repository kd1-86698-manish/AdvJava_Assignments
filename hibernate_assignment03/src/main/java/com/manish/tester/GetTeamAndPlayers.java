package com.manish.tester;

import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.manish.daos.TeamsDao;
import com.manish.daos.TeamsDaoImpl;
import com.manish.entities.Teams;

public class GetTeamAndPlayers {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {

			TeamsDao teamDao = new TeamsDaoImpl();

			System.out.print("Enter Team Id to Search :");
			Long teamId = sc.nextLong();

			Teams team = teamDao.getTeamAndPlayers(teamId);

			System.out.println(team);
			System.out.println("All Players : ");

			team.getPlayers().forEach(System.out::println);

		} catch (Exception e) {
			throw e;
		}

	}

}
