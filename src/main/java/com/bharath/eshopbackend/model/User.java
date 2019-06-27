package com.bharath.eshopbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	@Id
	private String email;
	@ManyToOne(cascade = CascadeType.ALL)
	private ShippingAddress shippingAddress;
		private String password;
		private String username;
		private int mobilenumber;
		private  String address;
		private String role;
	    private Boolean enabled;
	    
		public ShippingAddress getShippingAddress() {
			return shippingAddress;
		}
		public void setShippingAddress(ShippingAddress shippingAddress) {
			this.shippingAddress = shippingAddress;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getMobilenumber() {
			return mobilenumber;
		}
		public void setMobilenumber(int mobilenumber) {
			this.mobilenumber = mobilenumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public Boolean getEnabled() {
			return enabled;
		}
		public void setEnabled(Boolean enabled) {
			this.enabled = enabled;
		}
}
