package com.ms.fullstack.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	
	@GetMapping
	String home() {
		return "home";
	}
	
	@GetMapping("/date-times")
	String dateTimes() {
		return "date-times";
	}
	
	@GetMapping("/objects")
	String dataTypes(ModelMap model) {
		model.put("notNullValue", "This in not null value");
		model.put("nullValue", null);
		return "objects";
	}
	
	@GetMapping("bools")
	String bools() {
		return "bools";
	}
	
	@GetMapping("numbers")
	String numbers() {
		return "numbers";
	}
	
	@GetMapping("strings")
	String strings() {
		return "strings";
	}
	
	@GetMapping("/collections")
	String collections(ModelMap model) {
		Comparator<Integer> reverse = (o1, o2) -> o2 - o1;
		model.put("reverseSort", reverse);
		return "collections";
	}
	
	@GetMapping("/others")
	String others(ModelMap model) {
		model.put("subjects", List.of("Java", "Spring", "Angular", "Flutter"));
		return "others";
	}
}
