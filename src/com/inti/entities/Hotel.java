package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHotel;
	private String name;
	private int nbStar;
	
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
	
}
