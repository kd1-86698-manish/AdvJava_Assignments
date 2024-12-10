package com.manish.tester;

import org.hibernate.SessionFactory;
import com.manish.utils.*;
import static com.manish.utils.HibernateUtils.getSessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running !!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
