package com.inti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Destination;
import com.inti.entities.Hotel;
import com.inti.service.impl.DestinationService;
import com.inti.service.impl.HotelService;
import com.inti.service.interfaces.IDestinationService;
import com.inti.service.interfaces.IHotelService;

@ManagedBean
@SessionScoped
public class HotelManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Hotel hotel = new Hotel();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	private List<Destination> destinations = new ArrayList<Destination>();
	IHotelService hotelService = new HotelService();
	IDestinationService destinationService = new DestinationService();

	
	public HotelManagedBean() {

	}
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Hotel> getHotels() {
		this.hotels = hotelService.findAll(Hotel.class);
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Destination> getDestinations() {
		this.destinations = destinationService.findAll(Destination.class);
		return destinations;
	}

	public void setDestinations(List<Destination> destinations) {
		this.destinations = destinations;
	}

	@PostConstruct
	private void init() {
		this.hotels = hotelService.findAll(Hotel.class);
	}
	
	public void refresh() {
		init();
	}
	
	public void saveHotel() {
		try {
			hotelService.save(this.hotel);
			this.hotel = new Hotel();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteHotel(Hotel hotel) {
		try {
			hotelService.remove(hotel);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String edit(Hotel hotel) {
		this.hotel = hotel;
		return "updateHotel";
	}
	
	public String update() {
		try {
			hotelService.update(this.hotel);
			this.hotel = new Hotel();
			return "main?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "updateHotel";
		}
	}
}
