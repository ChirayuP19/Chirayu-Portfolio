<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Service</title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/client/home"> Client
		Page </a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/admin/home"> Admin Home
	</a>
	<br>
	
	<form action="${pageContext.request.contextPath}/admin/updateService"
		method="post" enctype="multipart/form-data">

		<input type="hidden" name="id" value="${serviceData.id}"><br><br>
		<input type="hidden" name="oldfilename" value="${serviceData.filename}"><br><br>
		<input type="text" name="title" placeholder="enter title " value="${serviceData.title}"><br><br>
		<textarea name="description">${serviceData.description}</textarea><br><br>
		<input type="file" name="serviceFile">
		<br><br>
		<button>Save</button>
	</form>

</body>
</html>