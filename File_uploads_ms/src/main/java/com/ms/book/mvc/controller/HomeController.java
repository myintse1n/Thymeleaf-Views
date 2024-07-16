package com.ms.book.mvc.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ms.book.root.entity.Book;
import com.ms.book.root.service.BookService;
@Controller
@RequestMapping(value = {"/home","/book"})
public class HomeController {
	
	@Autowired
	private BookService bookService;

	@GetMapping
	String home(
			@RequestParam(required = false) String keyword,
			@RequestParam(required = false) Integer category, 
			ModelMap model) {
		
		model.put("list",bookService.search(keyword, category));
		return "home";
	}
	
	@GetMapping("edit")
	String edit() {
		return "book-edit";
	}
	
	@PostMapping
	String save(@ModelAttribute("book") @Validated Book book,
			BindingResult result, RedirectAttributes redirect ) {
		
		
		if(result.hasErrors()) {
			return "book-edit";
		}
		
		var id = bookService.save(book);
		redirect.addAttribute("id", id);
		
		return "redirect:/home";
	}
	
	@ModelAttribute(name = "book")
	public Book book(@RequestParam Optional<Integer> id) {
		return id.flatMap(a-> bookService.findById(a)).orElse(new Book());
	}
}
