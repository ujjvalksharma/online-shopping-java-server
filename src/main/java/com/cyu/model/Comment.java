package com.cyu.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

@Entity(name = "Comment")
@Table(name = "Comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int prodId;
	
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private Person user;
	String text;
	
	
	@OneToMany(mappedBy="comment",cascade = CascadeType.ALL) //Comment comment; "comment" is basically the variable name comment
	@JsonIgnore
    private List<InnerComment> innerComments;
	
	public Comment() {
		
	}

	public Comment(int id, int prodId, Person user, String text) {
		super();
		this.id = id;
		this.prodId = prodId;
		this.user = user;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", prodId=" + prodId + ", user=" + user + ", text=" + text + "]";
	}

	
	

}
