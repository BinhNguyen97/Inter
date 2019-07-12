package com.nguyenthanhbinh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private int ID; 
	@Column(name = "BookName", nullable = false)
	private String Bookname;
	
	@Column(name = "Introdue", nullable = false)
	private String Introdue;
	
	@Column(name = "Content")
	private String Content;

	@Column(name = "Username")
	private String Username;
	@Column(name = "img")
	private String img;

	
	public Book(){
	super();
		
	}
	public Book(int ID, String Bookname,String Introdue, String Content,String Username,String img ) {
		super();
		this.ID=ID;
		this.Bookname=Bookname;
		this.Introdue=Introdue;
		this.Content=Content;
		this.Username=Username;
		this.img=img;
		
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookName(String bookName) {
		Bookname = bookName;
	}
	public String getIntrodue() {
		return Introdue;
	}
	public void setIntrodue(String introdue) {
		Introdue = introdue;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
	