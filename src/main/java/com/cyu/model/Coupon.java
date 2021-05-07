package com.cyu.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;

@Entity(name = "Coupon")
@Table(name = "Coupon")
public class Coupon {
	
	   
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Id
	    private int id;
		
	    private String name;
	    
	    @JsonFormat(pattern="yyyy-MM-dd")
	    private Date startDate;

	    @JsonFormat(pattern="yyyy-MM-dd")
	    private Date endDate;
	    
	    int discount;
	    
	    public Coupon(){
	    	
	    }

		public Coupon(int id, String name, Date startDate, Date endDate, int discount) {
			super();
			this.id = id;
			this.name = name;
			this.startDate = startDate;
			this.endDate = endDate;
			this.discount = discount;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public int getDiscount() {
			return discount;
		}

		public void setDiscount(int discount) {
			this.discount = discount;
		}

		@Override
		public String toString() {
			return "Coupon [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
					+ ", discount=" + discount + "]";
		}

	
	    
	    

}
