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


	<p style="color:red">${result}</p>

	<br><p>${error}</p>


	<form action="${pageContext.request.contextPath}/admin/addservice"
		method="post" enctype="multipart/form-data">

		<c:forEach var="err" items="${error}">
			<c:set var="isFieldError"
				value="${err.getClass().name.contains('FieldError')}" />
			<c:if test="${isFieldError && err.field eq 'title'}">
				<span style="color: red;">${err.defaultMessage}</span>
			</c:if>
		</c:forEach>

		<input type="text" name="title" placeholder="enter title"><br>
		<br>
		<c:forEach var="err" items="${error}">
			<c:set var="isFieldError"
				value="${err.getClass().name.contains('FieldError')}" />
			<c:if test="${isFieldError && err.field eq 'description'}">
				<span style="color: red;">${err.defaultMessage}</span>
			</c:if>
		</c:forEach>
		<br>


		<textarea name="description"></textarea>
		<br> ${Fileerror} <br> <br> <input type="file"
			name="serviceFile"><br> <br>
		<button>Save</button>

	</form>
</body>
</html>