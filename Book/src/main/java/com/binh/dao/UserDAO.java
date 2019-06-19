package com.binh.dao;

import java.util.List;

import com.binh.model.User;

public interface UserDAO {

	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserByUsermane(String usermame );
	public void removeUser(int id);
}