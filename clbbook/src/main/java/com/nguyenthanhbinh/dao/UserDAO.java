package com.nguyenthanhbinh.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenthanhbinh.daoimp.UserImp;
import com.nguyenthanhbinh.entity.User;
@Repository
public class UserDAO  {
	@Autowired
	SessionFactory sessionFactory;
	
	public User KiemTraDangNhap(String username,String password) {
	Session session=sessionFactory.getCurrentSession();
	try {
		User u=(User) session.createQuery("FROM user WHERE username='"+ username +"' AND password='"+ password +"'").getSingleResult();
			return u;
	}
	catch (Exception e) {
		return null;
	}

	}
	
	@Transactional
	public boolean AddUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		 int id=(int) session.save(user);
		 
		 if(id>0) {
			 return true;
		 }
		return false;
	} 

}
