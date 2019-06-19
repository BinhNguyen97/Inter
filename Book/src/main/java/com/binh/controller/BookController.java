package com.binh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	@RequestMapping("/")
	public String View() {
		return "book";
	}
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
}
