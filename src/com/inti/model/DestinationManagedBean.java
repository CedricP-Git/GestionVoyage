package com.inti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Destination;
import com.inti.service.impl.DestinationService;
import com.inti.service.interfaces.IDestinationService;

@ManagedBean
@SessionScoped
public class DestinationManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Destination destination = new Destination();
	private List<Destination> destinations = new ArrayList<Destination>();
	IDestinationService destinationService = new DestinationService();
	
	public DestinationManagedBean() {

	}
	
	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
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
		this.destinations = destinationService.findAll(Destination.class);
	}
	
	public void refresh() {
		init();
	}
	
	public void saveDestination() {
		try {
			destinationService.save(this.destination);
			this.destination = new Destination();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDestination(Destination destination) {
		try {
			destinationService.remove(destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String edit(Destination destination) {
		this.destination = destination;
		return "updateDestination";
	}
	
	public String update() {
		try {
			destinationService.update(this.destination);
			this.destination = new Destination();
			return "main?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "updateDestination";
		}
	}
}
