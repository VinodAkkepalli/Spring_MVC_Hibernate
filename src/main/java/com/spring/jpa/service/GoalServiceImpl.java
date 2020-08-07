package com.spring.jpa.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.jpa.model.Goal;
import com.spring.jpa.model.GoalReport;
import com.spring.jpa.repository.GoalRepository;

@Service(value = "GoalService")
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	/* this annotation takes care of starting/closing/rollingback of transactions */
	@Transactional
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

	public List<Goal> findAllGoals() {
		return goalRepository.findAll();
	}

	public List<GoalReport> findAllGoalReports() {
		return goalRepository.loadAllGoalReports();
	}

}
