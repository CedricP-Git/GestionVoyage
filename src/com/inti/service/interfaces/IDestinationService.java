package com.inti.service.interfaces;

import com.inti.entities.Destination;

public interface IDestinationService extends IService<Destination>  {
	
	Destination searchDestinationByName(String name);

}
