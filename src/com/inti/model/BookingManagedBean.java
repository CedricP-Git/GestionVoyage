package com.inti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Booking;
import com.inti.entities.Hotel;
import com.inti.entities.Comment;
import com.inti.entities.Traveler;
import com.inti.service.impl.BookingService;
import com.inti.service.impl.HotelService;
import com.inti.service.impl.CommentService;
import com.inti.service.impl.TravelerService;
import com.inti.service.interfaces.IBookingService;
import com.inti.service.interfaces.IHotelService;
import com.inti.service.interfaces.ICommentService;
import com.inti.service.interfaces.ITravelerService;

@ManagedBean
@SessionScoped
public class BookingManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Booking booking = new Booking();
	private List<Booking> bookings = new ArrayList<Booking>();
	private List<Comment> Comments = new ArrayList<Comment>();
	private List<Traveler> travelers = new ArrayList<Traveler>();
	IBookingService bookingService = new BookingService();
	ICommentService CommentService = new CommentService();
	ITravelerService travelerService = new TravelerService();

	
	public BookingManagedBean() {

	}
	
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<Booking> getBookings() {
		this.bookings = bookingService.findAll(Booking.class);
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Comment> getComments() {
		this.Comments = CommentService.findAll(Comment.class);
		return Comments;
	}

	public void setComments(List<Comment> Comments) {
		this.Comments = Comments;
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
		this.bookings = bookingService.findAll(Booking.class);
	}
	
	public void refresh() {
		init();
	}
	
	public void saveBooking() {
		try {
			bookingService.save(this.booking);
			this.booking = new Booking();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBooking(Booking booking) {
		try {
			bookingService.remove(booking);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String edit(Booking booking) {
		this.booking = booking;
		return "updateBooking";
	}
	
	public String update() {
		try {
			bookingService.update(this.booking);
			this.booking = new Booking();
			return "main?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "updateBooking";
		}
	}
}
