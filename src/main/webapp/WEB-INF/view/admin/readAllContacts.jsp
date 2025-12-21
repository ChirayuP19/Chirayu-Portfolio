<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/client/home">CLIENT PAGE</a><br><br>
<a href="${pageContext.request.contextPath}/admin/home">ADMIN HOME</a><br><br>
<h1>ALL contacts</h1><br><br>

<c:forEach var="contact" items="${contactData}">
<br>${contact.id}<br>
${contact.name}<br>
${contact.subject}<br>
${contact.message}<br>
${contact.datatime}<br><br>
<a href="${pageContext.request.contextPath}/admin/deleteContactByID?id=${contact.id}">DELETE</a><br>

</c:forEach>

</body>
</html>