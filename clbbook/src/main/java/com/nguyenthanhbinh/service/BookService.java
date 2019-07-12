package com.nguyenthanhbinh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenthanhbinh.dao.BookDAO;
import com.nguyenthanhbinh.daoimp.BookImp;
import com.nguyenthanhbinh.entity.Book;
import com.nguyenthanhbinh.entity.User;
@Service
public class BookService implements BookImp {
	@Autowired
	BookDAO bookDAO;
	@Override
	public List<Book> getListBook(User u) {
		 List<Book> listbook=bookDAO.getListBook(u);
		return listbook;
	}
	public List<Book>getAllBook() {
		 List<Book> allbook=bookDAO.getAllBook();
		return allbook;
	}
	@Override
	public boolean AddBook(Book book) {
		boolean ktAddBook=bookDAO.AddBook(book);
		return ktAddBook;
		
	}

}
