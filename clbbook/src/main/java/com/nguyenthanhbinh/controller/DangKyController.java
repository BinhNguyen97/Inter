package com.nguyenthanhbinh.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenthanhbinh.entity.User;
import com.nguyenthanhbinh.service.UserService;

@Controller
@RequestMapping("dangnhap/dangky/")
public class DangKyController {

	@GetMapping
	public String Default(){
		return "dangki";
	}

	@Autowired
	UserService userService;

	@PostMapping
	@Transactional
	public String DangKy(@RequestParam String username, @RequestParam String password,@RequestParam String fullname,@RequestParam String address, @RequestParam String phone){
		 User user=new User();
		 user.setUsername(username);
		 user.setPassword(password);
		 user.setFullname(fullname);
		 user.setAddress(address);
		 user.setPhone(phone);
		  boolean ktAdd=userService.AddUser(user);
		
		  if(ktAdd)	{	 
			  return "index";
		  }
		  else {
			  return "dangky";
		  }
	}
	


}
