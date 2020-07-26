package com.spring.jpa.service;

import java.util.List;

import com.spring.jpa.model.Activity;
import com.spring.jpa.model.Exercise;

public interface ExerciseService {

	List<Activity> findAllActivities();
	
	Exercise save(Exercise exercise);

}