package com.inti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Traveler;
import com.inti.service.impl.TravelerService;
import com.inti.service.interfaces.ITravelerService;

@ManagedBean
@SessionScoped
public class TravelerManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Traveler traveler = new Traveler();
	private List<Traveler> travelers = new ArrayList<Traveler>();
	ITravelerService travelerService = new TravelerService();
	
	public TravelerManagedBean() {

	}
	
	public Traveler getTraveler() {
		return traveler;
	}

	public void setTraveler(Traveler traveler) {
		this.traveler = traveler;
	}

	public List<Traveler> getTravelers() {
		this.travelers = travelerService.findAll(Traveler.class);
		return travelers;
	}

	public void setTravelers(List<Traveler> travelers) {
		this.travelers = travelers;
	}

	@PostConstruct
	private void init() {
		this.travelers = travelerService.findAll(Traveler.class);
	}
	
	public void refresh() {
		init();
	}
	
	public void saveTraveler() {
		try {
			travelerService.save(this.traveler);
			this.traveler = new Traveler();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTraveler(Traveler traveler) {
		try {
			travelerService.remove(traveler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String edit(Traveler traveler) {
		this.traveler = traveler;
		return "updateTraveler";
	}
	
	public String update() {
		try {
			travelerService.update(this.traveler);
			this.traveler = new Traveler();
			return "main?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "updateTraveler";
		}
	}
}
