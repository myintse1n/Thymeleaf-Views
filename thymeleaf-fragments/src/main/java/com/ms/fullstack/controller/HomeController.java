package com.ms.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@Autowired
	private OnePieceCrewMemberService service;
	
	@GetMapping("/")
	String home(ModelMap model) {
		model.put("crewMemberList", service.findAllCrewMembers());
		return "home";
	}
	
	@GetMapping("/page1")
	String pageOne() {
		return "pageOne";
	}
	
	@GetMapping("/page2")
	String pageTwo() {
		return "pageTwo";
	}
	
}
