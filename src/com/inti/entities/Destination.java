package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Destination implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestination;
	private Long longitude;
	private Long latitude;
	@OneToMany(mappedBy = "destination")
	private Set<Hotel> hotels = new HashSet<Hotel>();
	
	public Destination() {

	}
	
	public Destination(Long longitude, Long latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Long getIdDestination() {
		return idDestination;
	}
	
	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}
	
	public Long getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
	
	public Long getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(Set<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	
	
	
}
