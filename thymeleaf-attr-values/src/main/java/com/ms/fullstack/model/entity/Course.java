package com.ms.fullstack.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please enter course name")
	@Column(nullable = false, unique = true)
	private String name ;
	@NotNull(message = "Please choose course level")
	@Column(nullable = false)
	private Level level;
	private String months;
	private String fees;
	private String remark;
	
	public enum Level{
		Basic , Intermediate, Advanced
	}
}
