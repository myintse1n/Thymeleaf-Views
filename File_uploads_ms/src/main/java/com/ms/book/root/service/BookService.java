package com.ms.book.root.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.ms.book.root.entity.Book;
import com.ms.book.root.repo.BookRepo;

@Service
@Transactional(readOnly = true)
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	public List<Book> search(String keyword , Integer category) {
		
		List<Specification<Book>> list = new ArrayList<>();
		
		if(StringUtils.hasLength(keyword)) {
			Specification<Book> specification = (root, query, cb) ->{
				var likeName  = cb.like(cb.lower(root.get("category").get("name")), keyword.toLowerCase().concat("%"));
				var likeTitle = cb.like(cb.lower(root.get("title")), keyword.toLowerCase().concat("%"));
				var likeAuthor= cb.like(cb.lower(root.get("author")), keyword.toLowerCase().concat("%"));
				
				return cb.or(likeName,likeAuthor,likeTitle);
			};
			list.add(specification);
		}
		
		if(null != category && category > 0) {
			list.add((root, query, cb) -> cb.equal(root.get("category").get("id"), category));
		}
		
		return bookRepo.findAll(Specification.allOf(list));
	}

	public Optional<Book> findById(Integer id){
		return Optional.ofNullable(bookRepo.findById(id)).orElseThrow();
	}
	
	public int  save(Book book) {
		return bookRepo.save(book).getId();
	}
}
