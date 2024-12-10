package com.manish.tester;

import org.hibernate.SessionFactory;

import com.manish.daos.PlayersDao;
import com.manish.daos.PlayersDaoImpl;

import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class RemovePlayerFromTeam {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {

			PlayersDao playerDao = new PlayersDaoImpl();

			System.out.println("Enter Team Id : ");
			Long teamId = sc.nextLong();
			System.out.println("Enter Player Id : ");
			Long playerId = sc.nextLong();

			System.out.println(playerDao.removePlayer(teamId, playerId));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
