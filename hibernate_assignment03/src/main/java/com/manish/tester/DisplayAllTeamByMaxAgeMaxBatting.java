package com.manish.tester;

import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.manish.daos.TeamsDao;
import com.manish.daos.TeamsDaoImpl;

public class DisplayAllTeamByMaxAgeMaxBatting {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {

			TeamsDao teamDao = new TeamsDaoImpl();

			System.out.print("Enter Max age of Player : ");
			int max = sc.nextInt();
			System.out.print("Enter Batting Average : ");
			double avg = sc.nextDouble();

			teamDao.getAllSelectedTeam(max, avg).forEach(System.out::println);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
