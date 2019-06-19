package com.binh.model;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

@Entity
@Table(name = "user") 

public class User { 
	
	private static final long serialVersionUID= 1L;
	
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "fullname")
	private String fullname;

	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	public User(){
		super();
		
	}
	public User(String username,String password, String fullname, String address, String phone  ) {
		super();
		this.username=username;
		this.password=password;
		this.fullname=fullname;
		this.address=address;
		this.phone=phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}
