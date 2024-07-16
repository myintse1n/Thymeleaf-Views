package com.ms.book.root.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.ms.book.root.entity.Book;

public interface BookRepo extends JpaRepositoryImplementation<Book, Integer> {
	
}
