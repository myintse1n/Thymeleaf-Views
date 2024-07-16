package com.ms.book.root.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.ms.book.root.entity.Category;

public interface CategoryRepo extends JpaRepositoryImplementation<Category, Integer> {

}
