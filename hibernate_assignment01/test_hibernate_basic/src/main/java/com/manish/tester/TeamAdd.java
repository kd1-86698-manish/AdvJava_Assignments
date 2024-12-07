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

			Teams team = new Teams(sc.next(), sc.next().toUpperCase(), sc.next(), sc.nextInt(), sc.nextDouble(),
					sc.nextInt());

			System.out.println(teamdao.addUpTeam(team));

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
