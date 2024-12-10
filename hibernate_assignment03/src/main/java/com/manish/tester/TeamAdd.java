package com.manish.tester;

import com.manish.daos.*;
import com.manish.entities.*;
import com.manish.utils.*;
import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

public class TeamAdd {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {

			TeamsDao teamdao = new TeamsDaoImpl();

			System.out.println(
					"Enter Details :\nString name, String abbreviation, String owner, int maxPlayerAge, double battingAvg,\r\n"
							+ "			int wicketsTaken ");

			System.out.print("Enter Name Of Team : ");
			String name = sc.nextLine();
			System.out.print("Enter Name Of Abbrivation: ");
			String abbrivation = sc.next().toUpperCase();
			System.out.print("Enter Name Of Owner Name: ");
			String owner = sc.next();
			System.out.print("Enter Max Age Of Player : ");
			int maxAge = sc.nextInt();
			System.out.print("Enter Max Bating Avg : ");
			double batAvg = sc.nextDouble();
			System.out.print("Enter Wickets Taken : ");
			int wicketsTaken = sc.nextInt();

			Teams team = new Teams(name, abbrivation, owner, maxAge, batAvg, wicketsTaken);

			System.out.println(teamdao.addUpTeam(team));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
