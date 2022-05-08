package com.kuchnia2.model;

public class Meal {
	private Integer id_meal;
	private String meal_name;
	private String kind;
	private String country;
	private Integer minutes_to_cook;
	private String recipe;
	
	public Meal() {
		
	}
	
	public Meal(Integer id_meal, String meal_name, String kind, String country, Integer minutes_to_cook,
			String recipe) {
		this(meal_name,kind,country,minutes_to_cook,recipe);
		this.id_meal = id_meal;
	}
		
	public Meal(String meal_name, String kind, String country, Integer minutes_to_cook,
			String recipe) {
		this.meal_name = meal_name;
		this.kind = kind;
		this.country = country;
		this.minutes_to_cook = minutes_to_cook;
		this.recipe = recipe;
	}

	public Integer getId_meal() {
		return id_meal;
	}

	public void setId_meal(Integer id_meal) {
		this.id_meal = id_meal;
	}

	public String getName() {
		return meal_name;
	}

	public void setName(String meal_name) {
		this.meal_name = meal_name;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getMinutes_to_cook() {
		return minutes_to_cook;
	}

	public void setMinutes_to_cook(Integer minutes_to_cook) {
		this.minutes_to_cook = minutes_to_cook;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Meal [id_meal=" + id_meal + ", meal_name=" + meal_name + ", kind=" + kind + ", country=" + country
				+ ", minutes_to_cook=" + minutes_to_cook + ", recipe=" + recipe + "]";
	}
	
	

	
}
