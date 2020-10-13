package com.inti.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.inti.dao.interfaces.ITravelerDAO;
import com.inti.entities.Traveler;
import com.inti.utils.HibernateUtility;

public class TravelerDAO extends BaseDAO<Traveler> implements ITravelerDAO {
	
	@Override
	public Traveler searchTravelerByName(String name) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Criteria crit = s.createCriteria(Traveler.class);
		crit.add(Restrictions.eq("name", name));
		return (Traveler) crit.uniqueResult();
	}

}
