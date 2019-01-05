<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Load Data</title>
</head>
<body background="E:/steerwise/adult-income-usa/bg01.jpg">
	<center>
		<h1>USA INCOME ANALYSIS</h1>
		<h2>LOAD DATA INTO MONGODB</h2>
	</center>
	<br>
	<br> Enter the following details :
	<br>
	<br>
	<br>
	<center>
		<form:form action="import-data" modelAttribute="dbdetails">
			<table border="2">
				<tr>
					<td>File Path</td>
					<td><form:input path="file" type="file" /></td>
				</tr>
				<tr>
					<td>Server Host</td>
					<td align="left"><form:input path="host"/></td>
				</tr>
				<tr>
					<td>Server Port</td>
					<td align="left"><form:input path="port" /></td>
				</tr>
				<tr>
					<td>Database name</td>
					<td align="left"><form:input path="database" /></td>
				</tr>
				<tr>
					<td>Collection name</td>
					<td align="left"><form:input path="collection" /></td>
				</tr>
				<tr>
				<td></td>
				<td><input type="submit" value="Import"></td>
			</tr>
			</table>
			<br>
			
	${dbdetails.status}
	</form:form>
	</center>
	<br>
	<p align="right">
		<a href="query">Query -></a>
	</p>
</body>
</html>