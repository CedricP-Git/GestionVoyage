package com.inti.service.impl;

import com.inti.dao.impl.TravelerDAO;
import com.inti.dao.interfaces.ITravelerDAO;
import com.inti.entities.Traveler;
import com.inti.service.interfaces.ITravelerService;

public class TravelerService extends BaseService<Traveler> implements ITravelerService {

	private ITravelerDAO travelerDAO = new TravelerDAO();
	
	@Override
	public Traveler searchTravelerByName(String name) {
		return travelerDAO.searchTravelerByName(name);
	}
	
}
