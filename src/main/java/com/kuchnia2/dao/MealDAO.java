package com.kuchnia2.dao;

import java.util.List;

import com.kuchnia2.model.Meal;

public interface MealDAO {
	public int insert(Meal meal);
	
	public int update(Meal meal);
	
	public Meal get(Integer id);
	
	public int delete(Integer id);
	
	public List<Meal> list();
}
