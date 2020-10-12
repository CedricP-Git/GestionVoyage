package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Destination implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDestination;
	private Long longitude;
	private Long latitude;
	
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
}
