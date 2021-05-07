package com.cyu.model;

public class Address {
	
	String city;
	String streetName;
	String state;
	String country;
	int zipcode;
	
	public Address() {
		
	}

	public Address(String city, String streetName, String state, String country, int zipcode) {
		super();
		this.city = city;
		this.streetName = streetName;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", streetName=" + streetName + ", state=" + state + ", country=" + country
				+ ", zipcode=" + zipcode + "]";
	}
	

}
