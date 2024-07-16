package com.ms.book.root.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "{book.title.notBlank}")
	@Column(nullable = false,unique = true)
	private String title;
	@NotBlank(message = "{book.author.notBlank}")
	@Column(nullable = false)
	private String author;
	@NotNull(message = "{book.category.notNull}")
	@ManyToOne
	private Category category;
	@Min(value = 3000,message = "{book.price.min}")
	@NotNull(message = "{book.price.notNull}")
	@Column(nullable = false)
	private Integer price;
	private String remark; 
}
