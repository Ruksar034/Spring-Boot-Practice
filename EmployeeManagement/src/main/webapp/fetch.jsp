<%@page import="com.example.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee Details</h1>

Name : ${employeeById.name}<br>
City : ${employeeById.city}<br>
UserName : ${employeeById.username}<br>
Password : ${employeeById.password}<br>
</body>
</html>