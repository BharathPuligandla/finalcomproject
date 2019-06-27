package com.bharath.eshopbackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShippingAddress 
{		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
	 	private int id;
	    private String hnoNumber;
	    private String streetName;
	    private String city;
	    private String state;
	    private String country;
	    private String zipcode;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getHnoNumber() {
			return hnoNumber;
		}
		public void setHnoNumber(String hnoNumber) {
			this.hnoNumber = hnoNumber;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
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
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
	    
}
