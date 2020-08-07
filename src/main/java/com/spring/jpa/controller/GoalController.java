package com.spring.jpa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.jpa.model.Goal;
import com.spring.jpa.model.GoalReport;
import com.spring.jpa.service.GoalService;

@Controller
@SessionAttributes("goal")	//Add goal object to our http session
public class GoalController {

	@Autowired
	GoalService goalService;
	
	@RequestMapping(value = "addGoal", method = RequestMethod.GET)
	public String addGoal(Model model, HttpSession session) {
		
		//session attribute goal is obtained from session object 
		Goal goal = (Goal) session.getAttribute("goal");
		if(goal == null) {
			goal = new Goal();
			goal.setMinutes(10);			
		}		
		model.addAttribute("goal", goal);
		
		return "addGoal";
	}
	
	@RequestMapping(value = "addGoal", method = RequestMethod.POST)
	public String updateGoal(@Valid @ModelAttribute("goal") Goal goal, BindingResult result) {
		
		System.out.println("result has errors: " + result.hasErrors());
		
		System.out.println("Goal set: " + goal.getMinutes());
		
		if(result.hasErrors()) {
			return "addGoal";
		} else {
			goalService.save(goal);
		}
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value = "getGoals", method = RequestMethod.GET)
	public String getGoals(Model model) {
		List<Goal> goals =  goalService.findAllGoals();
		
		model.addAttribute("goals", goals);
		
		return "getGoals";
	}
	
	@RequestMapping(value = "getGoalsReport", method = RequestMethod.GET)
	public String getGoalsReport(Model model) {
		List<GoalReport> goalReports = goalService.findAllGoalReports();
		
		model.addAttribute("goalReports", goalReports);
		return "getGoalsReport";
	}
	
}
