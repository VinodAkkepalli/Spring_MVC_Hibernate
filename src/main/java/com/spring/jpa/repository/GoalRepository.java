package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.jpa.model.Goal;
import com.spring.jpa.model.GoalReport;

@Repository("goalRepository")
public interface GoalRepository extends JpaRepository<Goal, Long> {

	@Query("Select new com.spring.jpa.model.GoalReport(g.minutes, e.minutes, e.activity)"
			+ " from Goal g, Exercise e where g.id = e.goal.id")
	List<GoalReport> loadAllGoalReports();
}
