package com.ms.thymeleaf.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.ms.thymeleaf.model.entity.State;

public interface StateRepo extends JpaRepositoryImplementation<State, Integer> {

}
