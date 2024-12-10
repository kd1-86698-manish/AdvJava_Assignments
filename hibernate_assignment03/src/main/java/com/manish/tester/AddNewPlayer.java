package com.manish.tester;

import org.hibernate.SessionFactory;

import com.manish.daos.PlayersDao;
import com.manish.daos.PlayersDaoImpl;
import com.manish.entities.Players;

import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class AddNewPlayer {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			PlayersDao playerDao = new PlayersDaoImpl();

			System.out.println("Enter Team id :");
			Long teamId = sc.nextLong();

			System.out.println("Enter Fist Name :");
			String fName = sc.next();

			System.out.println("Enter Last Name :");
			String lName = sc.next();

			System.out.println("Enter Date of Birth(yyyy-mm-dd) :");
			LocalDate dob = LocalDate.parse(sc.next());

			System.out.println("Enter Batting Avrage :");
			double bAvg = sc.nextDouble();

			System.out.println("Enter wickets Taken :");
			int wTaken = sc.nextInt();

			Players player = new Players(fName, lName, dob, bAvg, wTaken);

			System.out.println(playerDao.addPlayer(teamId, player));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
