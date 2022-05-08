package com.kuchnia2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.kuchnia2.model.Meal;

public class MealDAOImpl implements MealDAO {

	private JdbcTemplate jdbcTemplate;
	
	public MealDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int insert(Meal meal) {
		String sql = "INSERT INTO Meal (id_meal, meal_name, kind, country, minutes_to_cook, recipe) VALUES (seq_meal.nextval, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, meal.getName(), meal.getKind(), meal.getCountry(), meal.getMinutes_to_cook(), meal.getRecipe());
		
	}

	@Override
	public int update(Meal meal) {
		String sql = "UPDATE Meal SET meal_name=?, kind=?, country=?, minutes_to_cook=?, recipe=? WHERE id_meal=? ";
		return jdbcTemplate.update(sql, meal.getName(), meal.getKind(), meal.getCountry(), meal.getMinutes_to_cook(), meal.getRecipe(), meal.getId_meal());
	}

	@Override
	public Meal get(Integer id) {
		String sql = "SELECT * FROM Meal WHERE id_meal="+id;
		
		ResultSetExtractor<Meal> extractor = new ResultSetExtractor<Meal>() {

			@Override
			public Meal extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String meal_name = rs.getString("meal_name");
					String kind = rs.getString("kind");
					String country = rs.getString("country");
					Integer minutes_to_cook = rs.getInt("minutes_to_cook");
					String recipe = rs.getString("recipe");
					
					return new Meal(id, meal_name, kind, country, minutes_to_cook, recipe);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Meal WHERE id_meal="+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Meal> list() {
		String sql = "SELECT * FROM Meal";
		
		RowMapper<Meal> rowMapper = new RowMapper<Meal>() {

			@Override
			public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id_meal = rs.getInt("id_meal");
				String meal_name = rs.getString("meal_name");
				String kind = rs.getString("kind");
				String country = rs.getString("country");
				Integer minutes_to_cook = rs.getInt("minutes_to_cook");
				String recipe = rs.getString("recipe");
				
				return new Meal(id_meal, meal_name, kind, country, minutes_to_cook, recipe);
			}
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	

}
