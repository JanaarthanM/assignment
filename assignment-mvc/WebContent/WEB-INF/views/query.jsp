<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!String response = null;
	JSONArray jsonarray = new JSONArray();
	JSONObject json = new JSONObject();%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Query records</title>
</head>
<body background="E:/steerwise/adult-income-usa/bg01.jpg">
	<center>
		<h1>USA INCOME ANALYSIS</h1>
		<h2>QUERY RECORDS</h2>
	</center>
	<br>
	<form:form action="query-records" modelAttribute="formquery">
		<table border="2" bordercolor="black">
			<tr>
				<td>Enter the query</td>
				<td><form:input path="query" type="text" size="140" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Query"></td>
			</tr>
		</table>
		<table border="2" bordercolor="blue" bgcolor="cyan">
			<tr>
				<th>Native Country</th>
				<th>Hours per week</th>
				<th>Age</th>
				<th>Gender</th>
				<th>Capital Loss</th>
				<th>Capital Gain</th>
				<th>Race</th>
				<th>Male</th>
				<th>Years of Education</th>
				<th>fnlgwt</th>
				<th>Income > 50K</th>
				<th>Work class</th>
				<th>Marital Status</th>
			</tr>
		</table>
	${formquery.response}
	</form:form>
</body>
</html>