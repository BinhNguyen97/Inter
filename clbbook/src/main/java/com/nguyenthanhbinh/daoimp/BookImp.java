package com.nguyenthanhbinh.daoimp;

import java.util.List;

import com.nguyenthanhbinh.entity.Book;
import com.nguyenthanhbinh.entity.User;

public interface BookImp {
	List<Book> getListBook(User u);
	List<Book> getAllBook();
	boolean  AddBook(Book book);
	
}
