<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>World Meals</title>
</head>
<body>
	<div align="center">
		<h1>Meals List</h1>
		
		<h3><a href="new">New Meal</a></h3>
		
		<table border="1" cellpadding="5">
			<tr>
				<th>Number</th>
				<th>Name</th>
				<th>Kind</th>
				<th>Country</th>
				<th>Minutes to Cook</th>
				<th>Recipe</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${listMeal}" var="meal" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${meal.name}</td>
				<td>${meal.kind}</td>
				<td>${meal.country}</td>
				<td>${meal.minutes_to_cook}</td>
				<td>${meal.recipe}</td>
				<td>
					<a href="edit?id=${meal.id_meal}">Edit</a>
					&nbsp;&nbsp;
					<a href="delete?id=${meal.id_meal}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>