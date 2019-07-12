package com.nguyenthanhbinh.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nguyenthanhbinh.entity.Book;
import com.nguyenthanhbinh.service.BookService;



@Controller
@RequestMapping("dangnhap/addbook/")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping
	public String AddBook() {
		return "AddBook";
	
	}

	@PostMapping
	@Transactional
	public String XuLyAddBook(@RequestParam String bookName,@RequestParam String introdue,@RequestParam String content,@RequestParam String username,@RequestParam String img ,ModelMap modelMap ){
		System.out.println("hihi");
		Book book=new Book();
		book.setBookName(bookName);
		book.setIntrodue(introdue);
		book.setContent(content);
		book.setUsername(username);
		book.setImg(img);
		boolean ktAddBook=bookService.AddBook(book);
		
		 if(ktAddBook)	{	
			 modelMap.addAttribute("success","(*) Add success");
			 System.out.println("thanhbinh");
			 return "Personal";
		  }
		 return "Personal";
	}
	

}
