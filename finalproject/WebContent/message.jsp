<%@ page language="java" contentType="text/html; charset=UTF-8" 
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%-- 
	Name: Jennifer Byrne
	Date: March 29, 2020
	Notes: ENTD481 Final Project - This JSP page relays a message to the user if the email was sent or not.
--%>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="final.css">
	<title>Message Confirmation</title>
</head>
<body>
	<div id="container">
		<div id="sidebar">
			<ul>
				<li><a href="../index.html">Home</a></li>
			</ul>
		</div>
		<div id="content">
			<%out.print(request.getAttribute("Message"));%>
		</div>
	</div>
</body>
</html>