package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
	@OneToMany(mappedBy = "hotel")
	private Set<Booking> bookings = new HashSet<Booking>();
	@OneToMany(mappedBy = "hotel")
	private Set<Comment> comments = new HashSet<Comment>();
	
	public Hotel() {

	}
	
	public Hotel(String name, int nbStar, Destination destination) {
		this.name = name;
		this.nbStar = nbStar;
		this.destination = destination;
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

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
