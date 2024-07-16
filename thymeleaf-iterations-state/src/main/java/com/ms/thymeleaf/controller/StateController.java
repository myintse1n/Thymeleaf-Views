package com.ms.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.LazyContextVariable;

import com.ms.thymeleaf.model.entity.State;
import com.ms.thymeleaf.model.service.StateService;

@Controller
@RequestMapping("home")
public class StateController {
	
	@Autowired
	private StateService stateService;

	@GetMapping
	<T> String state(ModelMap model) {
		model.put("size", stateService.getCount());
		model.put("list", new LazyContextVariable<List<State>>() {

			@Override
			protected List<State> loadValue() {
				return stateService.getAll();
			}
		});
		return "state";
	}
	
	@PostMapping
	String upload(@RequestParam MultipartFile file) {
		stateService.upload(file);
		return "redirect:/home";
	}
}
