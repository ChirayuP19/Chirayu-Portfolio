<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="${pageContext.request.contextPath}/admin/readAllContacts">
		View All Contacts </a>
	<br>
	<br>

	<a href="${pageContext.request.contextPath}/client/home"> Client
		Page </a>
	<br>


	<p>${result}</p><br>
	
	
	<form action="${pageContext.request.contextPath}/admin/addservice"
		method="post" enctype="multipart/form-data">

		<c:forEach var="err" items="${error}">
			<c:if test="${err.field eq 'title'}">${err.defaultMessage}</c:if>
		</c:forEach><br>

		<input type="text" name="title" placeholder="enter title"><br>
		<br>

		<c:forEach var="err" items="${error}">
			<c:if test="${err.field eq 'description'}">${err.defaultMessage}</c:if>
		</c:forEach><br>

		
		<textarea name="description"></textarea><br>
		${Fileerror}
		<br> <br> <input type="file" name="serviceFile"><br>
		
		<br>
		<button>Save</button>

	</form>
</body>
</html>