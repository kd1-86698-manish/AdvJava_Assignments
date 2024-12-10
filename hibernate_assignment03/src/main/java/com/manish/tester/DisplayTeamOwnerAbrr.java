package com.manish.tester;

import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.manish.daos.TeamsDao;
import com.manish.daos.TeamsDaoImpl;

public class DisplayTeamOwnerAbrr {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			TeamsDao teamDao = new TeamsDaoImpl();

			System.out.println("Enter Age : ");
			int age = sc.nextInt();

			System.out.println("Enter Bat Avg : ");
			double avg = sc.nextDouble();

			teamDao.displayOwnerNameAndAbbreviations(age, avg)
					.forEach(t -> System.out.println(t.getOwner() + " " + t.getAbbreviation()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
