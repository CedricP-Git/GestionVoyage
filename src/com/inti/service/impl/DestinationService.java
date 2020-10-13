package com.inti.service.impl;

import com.inti.dao.impl.DestinationDAO;
import com.inti.dao.interfaces.IDestinationDAO;
import com.inti.entities.Destination;
import com.inti.service.interfaces.IDestinationService;

public class DestinationService extends BaseService<Destination> implements IDestinationService {

	private IDestinationDAO destinationDAO = new DestinationDAO();
	
	@Override
	public Destination searchDestinationByName(String name) {
		return destinationDAO.searchDestinationByName(name);
	}
	
}
