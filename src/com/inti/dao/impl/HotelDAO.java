package com.inti.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.inti.dao.interfaces.IHotelDAO;
import com.inti.entities.Hotel;
import com.inti.utils.HibernateUtility;

public class HotelDAO extends BaseDAO<Hotel> implements IHotelDAO {

	@Override
	public Hotel searchHotelByName(String name) {
		Session s = HibernateUtility.getSessionFactory().openSession();
		Criteria crit = s.createCriteria(Hotel.class);
		crit.add(Restrictions.eq("name", name));
		return (Hotel) crit.uniqueResult();
	}
	
}
