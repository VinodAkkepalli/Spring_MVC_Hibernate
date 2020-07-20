package com.pluralsight.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluralsight.model.Goal;
import com.pluralsight.repository.GoalRepository;

@Service(value = "GoalService")
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalRepository goalRepository;
	
	/* this annotation takes care of starting/closing/rollingback of transactions */
	@Transactional
	public Goal save(Goal goal) {
		return goalRepository.save(goal);
	}

}
