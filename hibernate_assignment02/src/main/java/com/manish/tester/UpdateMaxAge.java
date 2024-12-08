package com.manish.tester;

import org.hibernate.SessionFactory;

import com.manish.daos.TeamsDao;
import com.manish.daos.TeamsDaoImpl;

import static com.manish.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class UpdateMaxAge {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)) {

			TeamsDao teamDao = new TeamsDaoImpl();
			System.out.println("Enter Team Name");
			String tName = sc.nextLine();

			System.out.println("Update Max Age :");
			int mAge = sc.nextInt();

			System.out.println(teamDao.updateMaxPlayerAge(tName, mAge));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
