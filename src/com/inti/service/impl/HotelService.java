package com.inti.service.impl;

import com.inti.dao.impl.HotelDAO;
import com.inti.dao.interfaces.IHotelDAO;
import com.inti.entities.Hotel;
import com.inti.service.interfaces.IHotelService;

public class HotelService extends BaseService<Hotel> implements IHotelService {
	
	private IHotelDAO hotelDAO = new HotelDAO();
	
	@Override
	public Hotel searchHotelByName(String name) {
		return hotelDAO.searchHotelByName(name);
	}

}
