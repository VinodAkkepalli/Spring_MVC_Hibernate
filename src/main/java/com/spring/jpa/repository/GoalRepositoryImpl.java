package com.spring.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.spring.jpa.model.Goal;
import com.spring.jpa.model.GoalReport;

@Repository(value="GoalRepository")
public class GoalRepositoryImpl implements GoalRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Goal save(Goal goal) {

		em.persist(goal);
		em.flush();
		return goal;
	}

	public List<Goal> loadAll() {

		Query query = em.createQuery("Select g from Goal g");
		
		List goals = query.getResultList();
		
		return goals;
	}

	public List<GoalReport> loadAllGoalReports() {
		Query query = em.createQuery("Select new com.spring.jpa.model.GoalReport(g.minutes, e.minutes, e.activity)"
				+ " from Goal g, Exercise e where g.id = e.goal.id");

		List goalReports = query.getResultList();

		return goalReports;
	}

}
