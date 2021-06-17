package dev.soer.utils;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
