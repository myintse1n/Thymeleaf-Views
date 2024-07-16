package com.ms.book.mvc.controller.advices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ms.book.root.entity.Category;
import com.ms.book.root.service.CategoryService;

@ControllerAdvice
public class CategoryControllerAdvice {

	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("categories")
	public List<Category> category(){
		return categoryService.getAll();
	}
}
