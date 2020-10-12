package com.inti.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	private String name;
	private int nbStar;
	@ManyToOne
	private Destination destination;
	@OneToMany(mappedBy = "idHotel")
	private List<Booking> bookings;
	@OneToMany(mappedBy = "idHotel")
	private List<Comment> comments;
	
	public Hotel() {

	}
	
	public Hotel(String name, int nbStar) {
		this.name = name;
		this.nbStar = nbStar;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbStar() {
		return nbStar;
	}

	public void setNbStar(int nbStar) {
		this.nbStar = nbStar;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	
	
}
