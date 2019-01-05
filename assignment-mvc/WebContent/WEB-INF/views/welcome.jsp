<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>USA Income Analysis</title>
</head>
<body background="E:/steerwise/adult-income-usa/bg01.jpg">
	<center>
		<h1>USA INCOME ANALYSIS</h1>
		<br> <br> <br>
		<img src="E:/steerwise/adult-income-usa/fig01.png" width="600"
			height="250">
	</center>
	<br>
	<br>
	<form action="/assignment/usa-income/load">
		<input type="submit" value="Load Data" />
	</form>

</body>
</html>