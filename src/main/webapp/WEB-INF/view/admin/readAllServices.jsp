<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Service readAllData</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/admin/home"> Admin Page
	</a>
	<br>
	<a href="${pageContext.request.contextPath}/client/home"> Client
		Page </a>
	<br>



	<h2>All Services</h2>
	<br>
	<h2>${error}</h2>
	<br>
	<br>
	<h2 style="color:green">${deletemsg}</h2>
	<br>

	<c:forEach var="service" items="${listOfServices}">

		<img style="width: 300px; height: auto;"
			src="${pageContext.request.contextPath}/img/services/${service.filename}"
			alt="">
		<h4>${service.title}</h4>
		<p>${service.description}</p>
		<br>
		<a href="${pageContext.request.contextPath}/admin/updateService?id=${service.id}">Update</a>
		<br><br>
		<a href="${pageContext.request.contextPath}/admin/deleteServices?id=${service.id}&filename=${service.filename}"
		onclick="return confirm('Are you sure you want to delete?');">
			Delete </a>
		<br>
		
	</c:forEach>
</body>
</html>