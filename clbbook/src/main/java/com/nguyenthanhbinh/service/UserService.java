package com.nguyenthanhbinh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenthanhbinh.dao.UserDAO;
import com.nguyenthanhbinh.daoimp.UserImp;
import com.nguyenthanhbinh.entity.User;

@Service
public class UserService implements UserImp {
	 @Autowired
	 UserDAO userDAO;
	 @Override
	public User KiemTraDangNhap(String username, String password) {
		User kiemtra=userDAO.KiemTraDangNhap(username, password);
		
		return kiemtra;
	}
	@Override
	public boolean AddUser(User user) {
		boolean ktAdd=userDAO.AddUser(user);
		return ktAdd;
	}
	
   	
}
