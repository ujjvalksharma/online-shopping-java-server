package com.cyu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "InnerComment")
@Table(name = "InnerComment")
public class InnerComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String text;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	 private Person user;
	
    @ManyToOne
    @JoinColumn(name="comment_id", nullable=false)
    private Comment comment;
    
	public InnerComment(){
		
	}

	public InnerComment(int id, String text, Person user, Comment comment) {
		super();
		this.id = id;
		this.text = text;
		this.user = user;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "InnerComment [id=" + id + ", text=" + text + ", user=" + user + ", comment=" + comment + "]";
	}


	
	
	
}
