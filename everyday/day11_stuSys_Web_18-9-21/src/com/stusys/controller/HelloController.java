package com.stusys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public String hello(HttpServletRequest request) {
		request.setAttribute("message","hello spring mvc!");
		return "hello";
	}

}
