package com.ms.fullstack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.fullstack.model.entity.Course;
import com.ms.fullstack.model.entity.Course.Level;
import com.ms.fullstack.model.service.CourseService;


@Controller
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	String search(
			@RequestParam Optional<Level> level,
			@RequestParam Optional<String> name,
			ModelMap map
			) {
		map.put("result", courseService.search(level,name));
		return "courses";
	}
	
	@GetMapping("edit")
	String edit() {
		return "course-edit";
	}
	
	@PostMapping
	String save(@ModelAttribute("course") @Validated Course course , BindingResult result) {
		
		if(result.hasErrors()) {
			return "course-edit";
		}
		
		courseService.save(course);
		return "redirect:/course";
	}
	
	@ModelAttribute("course")
	Course course(@RequestParam Optional<Integer> id) {
		return id.filter(a-> a> 0).map(courseService::findById).orElse(new Course());
	}
	
	@ModelAttribute("levels")
	List<Level> levels (){
		return List.of(Level.values());
	}
}
