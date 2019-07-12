package com.nguyenthanhbinh.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nguyenthanhbinh.entity.Book;
import com.nguyenthanhbinh.entity.User;
import com.nguyenthanhbinh.service.BookService;
import com.nguyenthanhbinh.service.UserService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {

	@GetMapping
	public String Default(){
		return "index";
	}
	@RequestMapping("dangky/")
	public String DangKy() {
		return "dangki";
	}
//	@RequestMapping("addbook/")
//	public String  AddBook() {
//		return "AddBook";
//	}
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	

	@PostMapping
	@Transactional 
	public String XulyDangNhap(@RequestParam String username ,@RequestParam String password, ModelMap modelMap) {
		
		User kiemtra=userService.KiemTraDangNhap(username, password);
		
		if(kiemtra!=null) {
			List<Book> listbook=bookService.getListBook(kiemtra);
			List<Book> allbook=bookService.getAllBook();
			System.out.println(listbook);
			modelMap.addAttribute("allbook",allbook);
			modelMap.addAttribute("listbook", listbook);
			modelMap.addAttribute("kiemtra",kiemtra);
			modelMap.addAttribute("fullname",username);
			return "Personal";
		}else {
			System.out.print("thatbai");
			modelMap.addAttribute("fail","* Đăng nhập thất bại !");
			return "index";
		}
		
	}
	
	//@GetMapping("delete/{id}")
	@RequestMapping(value = "/delete/{ID}/",method = RequestMethod.GET)
	public String delete(@PathVariable(value = "ID") int ID, RedirectAttributes redirect) {
		System.out.println("hi");
		redirect.addFlashAttribute("success", "Deleted Dictionary successfully!");
		return "redirect:dangnhap/";
	}


//	@PostMapping
//	@Transactional
//	public String XuLyAddBook(@RequestParam String BookName,@RequestParam String Introdue,@RequestParam String Content,@RequestParam String Username,@RequestParam String img  ){
//		Book book=new Book();
//		System.out.println("toi r");
//		book.setBookName(BookName);
//		book.setIntrodue(Introdue);
//		book.setContent(Content);
//		book.setUsername(Username);
//		book.setImg(img);
//		boolean ktAddBook=bookService.AddBook(book);
//		
//		 if(ktAddBook)	{	
//			 System.out.println("thanhcong"); 
//			  return "Personal";
//			
//		  }
//		  else {
//			  System.out.println("thatbat");
//			  return "AddBook";
//			 
//		  }
//	}
	


}
