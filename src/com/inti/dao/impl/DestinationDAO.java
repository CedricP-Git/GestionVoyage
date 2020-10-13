package com.inti.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.inti.dao.interfaces.IDestinationDAO;
import com.inti.entities.Destination;
import com.inti.utils.HibernateUtility;

public class DestinationDAO extends BaseDAO<Destination> implements IDestinationDAO {

	@Override
	public Destination searchDestinationByName(String name) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Criteria crit = s.createCriteria(Destination.class);
		crit.add(Restrictions.eq("name", name));
		return (Destination) crit.uniqueResult();
	}
	
}
