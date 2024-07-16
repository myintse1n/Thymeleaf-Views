package com.ms.thymeleaf.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(name = "state")
@NoArgsConstructor
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	@NonNull
	private String name ;
	@Column(nullable = false)
	@NonNull
	private String region;
	@Column(nullable = false)
	@NonNull
	private String capital;
	
	public State(String line ) {
		var string = line.split("\t");
		this.name = string[0];
		this.region= string[1];
		this.capital= string[2];
	}
}
