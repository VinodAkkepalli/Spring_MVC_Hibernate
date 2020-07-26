package com.spring.jpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.spring.jpa.model.Exercise;

@Repository(value="ExerciseRepository")
public class ExerciseRepositoryImpl implements ExerciseRepository {

	@PersistenceContext
	EntityManager em;
	
	public Exercise save(Exercise exercise) {

		em.persist(exercise);
		em.flush();
		return exercise;
	}

}
