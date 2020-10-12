package com.inti.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory sf;
	private HibernateUtility() {
		
	}
	
	@SuppressWarnings("deprecation")
	public static synchronized SessionFactory getSessionFactory() {
		if(sf == null) {
			sf = new Configuration().configure().buildSessionFactory();
		}
		return sf;
	}
}
