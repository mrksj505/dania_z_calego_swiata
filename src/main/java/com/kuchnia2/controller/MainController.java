package com.kuchnia2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kuchnia2.dao.MealDAO;
import com.kuchnia2.model.Meal;

@Controller
public class MainController {

	@Autowired
	private MealDAO mealDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listMeal(ModelAndView model) {
		List<Meal> listMeal = mealDAO.list();
		model.addObject("listMeal", listMeal);
		model.setViewName("index");
		return model;
	} 
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public ModelAndView newMeal(ModelAndView model) {
		Meal newMeal = new Meal();
		model.addObject("meal", newMeal);
		model.setViewName("meal_form");
		return model;
	} 
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveMeal(@ModelAttribute Meal meal) {
		if(meal.getId_meal()==null) {
			mealDAO.insert(meal);
		}
		else {
			mealDAO.update(meal);
		}
		return new ModelAndView("redirect:/");
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editMeal(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Meal meal = mealDAO.get(id);
		ModelAndView model = new ModelAndView("meal_form");
		
		model.addObject("meal", meal);
		
		return model;
		
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteMeal(@RequestParam Integer id) {
		mealDAO.delete(id);
		
		return new ModelAndView("redirect:/");
	}
}
