<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UploadResume</title>
</head>
<body>
	<h1>Upload Resume Here</h1>
	<br>
	<br> ${result}
	${uploaded}
	<br>
	<br>

	<a href="${pageContext.request.contextPath}/client/home"
		class="btn btn-outline-3d"> Client Page </a>
	<br>
	<br>

	<a href="${pageContext.request.contextPath}/admin/home"
		class="btn btn-outline-3d"> Admin Home Page </a>
	<br>
	<br>



	<form action="uploadResume" method="post" enctype="multipart/form-data">
		<input type="file" name="resume"><br> <br>
		<button>Upload</button>
		<br> <br>

	</form>
</body>
</html>