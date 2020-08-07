package com.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.model.Exercise;

@Repository("exerciseRepository")
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
	
}
