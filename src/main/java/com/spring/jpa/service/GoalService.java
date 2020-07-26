package com.spring.jpa.service;

import java.util.List;

import com.spring.jpa.model.Goal;
import com.spring.jpa.model.GoalReport;

public interface GoalService {

	Goal save(Goal goal);

	List<Goal> findAllGoals();

	List<GoalReport> findAllGoalReports();
}
