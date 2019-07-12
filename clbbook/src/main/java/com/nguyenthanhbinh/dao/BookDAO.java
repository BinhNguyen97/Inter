package com.nguyenthanhbinh.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenthanhbinh.entity.Book;
import com.nguyenthanhbinh.entity.User;
@Repository
public class BookDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Book> getListBook(User u) {
		Session session=sessionFactory.getCurrentSession();
		try {
			List<Book> listbook=(List<Book>) session.createQuery("FROM Book WHERE Username='"+u.getUsername() +"'").getResultList();
			return listbook;
		}
		catch (Exception e) {
			return null;
		}

	}
	public List<Book> getAllBook(){
		Session session=sessionFactory.getCurrentSession();
		try {
			List<Book> allbook=(List<Book>) session.createQuery("FROM Book").getResultList();
			return allbook;
		}
		catch (Exception e) {
			return null;
		}

	}
	@Transactional
	public boolean AddBook(Book book) {
		Session session=sessionFactory.getCurrentSession();
		 int ID=(int) session.save(book);
		 
		 if(ID>0) {
			 return true;
		 }
		return false;
	} 


}
