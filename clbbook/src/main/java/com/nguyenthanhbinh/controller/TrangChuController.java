package com.nguyenthanhbinh.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenthanhbinh.entity.User;

@Controller

public class TrangChuController {

	@RequestMapping("/")
	public String  TrangChu(){
		return "TrangChu";
	}
	
	

}

