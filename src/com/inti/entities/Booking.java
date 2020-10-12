package com.inti.entities;

import java.io.Serializable;
import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Booking implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBooking;
	private Date dateBooking;
	private Integer nbDays;
	@ManyToOne
	private Traveler traveller;
	
	public Booking() {}

	public Long getIdBooking() {
		return idBooking;
	}

	public void setIdBooking(Long idBooking) {
		this.idBooking = idBooking;
	}

	public Date getDateBooking() {
		return dateBooking;
	}

	public void setDateBooking(Date dateBooking) {
		this.dateBooking = dateBooking;
	}

	public Integer getNbDays() {
		return nbDays;
	}

	public void setNbDays(Integer nbDays) {
		this.nbDays = nbDays;
	}

	public Traveler getTraveller() {
		return traveller;
	}

	public void setTraveller(Traveler traveller) {
		this.traveller = traveller;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateBooking == null) ? 0 : dateBooking.hashCode());
		result = prime * result + ((idBooking == null) ? 0 : idBooking.hashCode());
		result = prime * result + ((nbDays == null) ? 0 : nbDays.hashCode());
		result = prime * result + ((traveller == null) ? 0 : traveller.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (dateBooking == null) {
			if (other.dateBooking != null)
				return false;
		} else if (!dateBooking.equals(other.dateBooking))
			return false;
		if (idBooking == null) {
			if (other.idBooking != null)
				return false;
		} else if (!idBooking.equals(other.idBooking))
			return false;
		if (nbDays == null) {
			if (other.nbDays != null)
				return false;
		} else if (!nbDays.equals(other.nbDays))
			return false;
		if (traveller == null) {
			if (other.traveller != null)
				return false;
		} else if (!traveller.equals(other.traveller))
			return false;
		return true;
	}
	
	
	
	
	

}
