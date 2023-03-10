<%-- 
	Name: Jennifer Byrne
	Date: March 29, 2020
	Notes: ENTD481 Final Project - Departments page
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
		 pageEncoding="UTF-8" import="java.sql.*"%>
<jsp:useBean id="deptbean" scope="session" class="finalproject.DeptBean" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="final.css">
	<title>Department List</title>
</head>
<body>
	<div id="container">
		<div id="sidebar">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="email.html">Contact Us</a></li>
			</ul>
		</div>
		<div id="content">
			<h1>List of Departments</h1>
			<table>
			<tr>
				<th>Dept No</th>
				<th>Dept Name</th>
			</tr>
<% 
	try {
		deptbean.setData();
		ResultSet pageRS = deptbean.getResult();
		
		while (pageRS.next()) {
		%>
			<tr>
				<td><%out.print(pageRS.getString("dept_no"));%></td>
				<td><%out.print(pageRS.getString("dept_name"));%></td>
			</tr>	
		<%}
	}
	catch (Exception e) {
		e.printStackTrace();
	}
%>
			</table>
		</div>
	</div>	
</body>
</html>