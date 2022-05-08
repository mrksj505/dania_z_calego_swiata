package com.kuchnia2.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.kuchnia2.model.Meal;

class MealDAOTest {

	private DriverManagerDataSource dataSource;
	private MealDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("user11347");
		dataSource.setPassword("mrksj");
		
		dao = new MealDAOImpl(dataSource);
	}
	
	@Test
	void testInsert() {
		
		Meal meal = new Meal("test","test","test", 0, "test");
		int result = dao.insert(meal);
		
		assertTrue(result>0);
	}

	@Test
	void testUpdate() {
		Meal meal = new Meal(2,"jajecznica","test","test", 0, "test");
		int result = dao.update(meal);
		
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Meal meal = dao.get(id);
		if(meal != null) {
			System.out.println(meal);
		}
		
		assertNotNull(meal);
	}

	@Test
	void testDelete() {
		Integer id = 3;
		int result = dao.delete(id);
		
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Meal> listMeals = dao.list();
		
		for(Meal aMeal : listMeals) {
			System.out.println(aMeal);
		}
		
		assertTrue(!listMeals.isEmpty());
	}

}
