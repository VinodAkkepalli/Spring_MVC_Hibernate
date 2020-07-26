package com.spring.jpa.repository;

import java.util.List;

import com.spring.jpa.model.Goal;
import com.spring.jpa.model.GoalReport;

public interface GoalRepository {

	Goal save(Goal goal);

	List<Goal> loadAll();

	List<GoalReport> loadAllGoalReports();
}
