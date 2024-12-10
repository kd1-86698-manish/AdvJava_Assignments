package com.manish.tester;

import org.hibernate.SessionFactory;

import com.manish.daos.TeamsDao;
import com.manish.daos.TeamsDaoImpl;

import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class DeleteTeamById {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			TeamsDao teamDao = new TeamsDaoImpl();
			System.out.println("Enter user id to un subscribe");
			System.out.println(teamDao.deleteTeamDetails(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
