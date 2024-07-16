package com.ms.book.root.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.book.root.entity.Category;
import com.ms.book.root.repo.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	public List<Category> getAll(){
		return categoryRepo.findAll();
	}

	public Optional<Category>  findById(Integer id) {
		return categoryRepo.findById(id);
	}
	

}
