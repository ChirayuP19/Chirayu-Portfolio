<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #1d3557, #457b9d);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .admin-card {
            background: #ffffff;
            border-radius: 16px;
            padding: 40px;
            width: 100%;
            max-width: 500px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
        }

        .admin-title {
            font-weight: 600;
            color: #1d3557;
        }

        .admin-subtitle {
            color: #6c757d;
            font-size: 14px;
        }

        .admin-btn {
            width: 100%;
            padding: 14px;
            font-weight: 500;
            border-radius: 10px;
            transition: all 0.3s ease;
        }

        .admin-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.15);
        }
    </style>
</head>

<body>

<div class="admin-card text-center">
    <h2 class="admin-title mb-2">Admin Dashboard</h2>
    <p class="admin-subtitle mb-4">Manage system operations securely</p>

    <div class="d-grid gap-3">
    
    <a href="${pageContext.request.contextPath}/admin/readAllContacts"
           class="btn btn-primary admin-btn">
            View All Contacts
        </a>
        
        <a href="${pageContext.request.contextPath}/client/home"
           class="btn btn-outline-dark admin-btn">
            Client Page
        </a>

        
    </div>
</div>

</body>
</html>
