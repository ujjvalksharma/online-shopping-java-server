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

/*
Entity is object-oriented and table is relation-oriented. You can only use the entity name in the HQL 
(Hibernate Query Language) to query objects, and the table name in the native SQL.

*/
@Entity(name = "Comment_hql") - persistence : this table name is used for HQL (hibernate query language) 
@Getter -lombok
@Setter -lombok
@ToString -lombok
@NoArgsConstructor -lombok
@ArgsConstructor -lombok
@Table(name = "Comment_mysql") - persistence : this table name is used for sql
public class Comment {
	
	@Id  ---- to define primary key : In hibernate primary key is always present
	@GeneratedValue(strategy = GenerationType.AUTO) --- How is the primary key generated, GenerationType.AUTO: autoincrement
	int id;
	int prodId;
	
    @ManyToOne. : is used one to many mapping
    @JoinColumn(name="user_id", nullable=false) : speciy the join column/ forigen key
    private Person user;
	String text;
	
	
	@OneToMany(mappedBy="comment",cascade = CascadeType.ALL) //Comment comment; "comment" is basically the variable name comment
	@JsonIgnore : This object can be ignored for some cases, if innerComments attricute is not found, we can still map object to the 
	               class with null value
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
