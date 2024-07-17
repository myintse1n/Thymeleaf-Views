package com.ms.fullstack.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.ms.fullstack.model.entity.Course;

@Repository
public interface CourseRepo extends JpaRepositoryImplementation<Course, Integer>{

}
