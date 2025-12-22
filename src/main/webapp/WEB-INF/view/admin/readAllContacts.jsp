<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>All Contacts | Admin Panel</title>

<!-- Bootstrap 5 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap"
	rel="stylesheet">

<style>
body {
	font-family: 'Poppins', sans-serif;
	background: #f4f6f9;
	min-height: 100vh;
}

.page-container {
	padding: 40px;
}

.page-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 30px;
}

.page-title {
	font-weight: 600;
	color: #1d3557;
}

.table-container {
	background: #ffffff;
	border-radius: 16px;
	padding: 25px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.08);
}

.table th {
	background-color: #1d3557;
	color: #ffffff;
	font-weight: 500;
	text-align: center;
	vertical-align: middle;
}

.table td {
	vertical-align: middle;
	text-align: center;
}

.action-btn {
	padding: 6px 14px;
	border-radius: 8px;
	font-size: 14px;
	transition: all 0.3s ease;
}

.action-btn:hover {
	transform: translateY(-1px);
	box-shadow: 0 6px 15px rgba(0, 0, 0, 0.15);
}

.nav-btns a {
	margin-right: 10px;
}
</style>
</head>

<body>

	<div class="page-container">

		<!-- Header -->
		<div class="page-header">
			<div>
				<h2 class="page-title mb-1">All Contact Messages</h2>
				<p class="text-muted mb-0">Manage and review user inquiries</p>
			</div>

			<div class="nav-btns">

				<a href="${pageContext.request.contextPath}/admin/home"
					class="btn btn-outline-primary action-btn"> Admin Home </a> <a
					href="${pageContext.request.contextPath}/client/home"
					class="btn btn-outline-dark action-btn"> Client Page </a>


			</div>
		</div>

		<!-- Table -->
		<div class="table-container">
			<table class="table table-hover table-bordered align-middle">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Subject</th>
						<th>Message</th>
						<th>Date & Time</th>
						<th>Action</th>
					</tr>
				</thead>

				<tbody>
					<c:choose>
						<c:when test="${empty contactData}">
							<tr>
								<td colspan="6" class="text-center text-muted py-4">No
									contact records found</td>
							</tr>
						</c:when>

						<c:otherwise>
							<c:forEach var="contact" items="${contactData}">
								<tr>
									<td>${contact.id}</td>
									<td>${contact.name}</td>
									<td>${contact.subject}</td>
									<td class="text-start">${contact.message}</td>
									<td>${contact.datatime}</td>
									<td><a
										href="${pageContext.request.contextPath}/admin/deleteContactByID?id=${contact.id}"
										class="btn btn-danger action-btn"
										onclick="return confirm('Are you sure you want to delete this contact?');">
											Delete </a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>

	</div>

</body>
</html>

<!-- this is without design code -->

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<%-- 	<a href="${pageContext.request.contextPath}/client/home">CLIENT --%>
<!-- 		PAGE</a> -->
<!-- 	<br> -->
<!-- 	<br> -->
<%-- 	<a href="${pageContext.request.contextPath}/admin/home">ADMIN HOME</a> --%>
<!-- 	<br> -->
<!-- 	<br> -->
<!-- 	<h1>ALL contacts</h1> -->
<!-- 	<br> -->
<!-- 	<br> -->
<%-- 	<c:forEach var="contact" items="${contactData}"> --%>
<%-- 		<br>${contact.id}<br> ${contact.name}<br> ${contact.subject}<br> ${contact.message}<br> ${contact.datatime}<br> --%>
<!-- 		<br> -->
<!-- 		<a -->
<%-- 			href="${pageContext.request.contextPath}/admin/deleteContactByID?id=${contact.id}">DELETE</a> --%>
<!-- 		<br> -->
<%-- 	</c:forEach> --%>
<!-- </body> -->
<!-- </html> -->
