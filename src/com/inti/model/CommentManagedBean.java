package com.inti.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.inti.entities.Hotel;
import com.inti.entities.Comment;
import com.inti.service.impl.HotelService;
import com.inti.service.impl.CommentService;
import com.inti.service.interfaces.IHotelService;
import com.inti.service.interfaces.ICommentService;

@ManagedBean
@SessionScoped
public class CommentManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Comment comment = new Comment();
	private List<Comment> comments = new ArrayList<Comment>();
	private List<Hotel> hotels = new ArrayList<Hotel>();
	ICommentService commentService = new CommentService();
	IHotelService hotelService = new HotelService();

	
	public CommentManagedBean() {

	}
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public List<Comment> getComments() {
		this.comments = commentService.findAll(Comment.class);
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Hotel> getHotels() {
		this.hotels = hotelService.findAll(Hotel.class);
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@PostConstruct
	private void init() {
		this.comments = commentService.findAll(Comment.class);
	}
	
	public void refresh() {
		init();
	}
	
	public void saveComment() {
		try {
			commentService.save(this.comment);
			this.comment = new Comment();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteComment(Comment comment) {
		try {
			commentService.remove(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String edit(Comment comment) {
		this.comment = comment;
		return "updateComment";
	}
	
	public String update() {
		try {
			commentService.update(this.comment);
			this.comment = new Comment();
			return "main?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			return "updateComment";
		}
	}
}
