<%@ page language="java" contentType="text/html; 
charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>

    <!-- Bootstrap 5 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Inter', sans-serif;
            background: linear-gradient(135deg, #4f86f7, #8fc1ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        /* Floating card */
        .admin-card {
            background: #ffffff;
            border-radius: 20px;
            padding: 50px 40px;
            width: 100%;
            max-width: 450px;
            text-align: center;
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.2);
            transition: transform 0.4s ease, box-shadow 0.4s ease;
        }
        .admin-card:hover {
            transform: translateY(-10px);
            box-shadow: 0 30px 60px rgba(0, 0, 0, 0.25);
        }

        /* Title */
        .admin-title {
            font-size: 2.2rem;
            font-weight: 700;
            color: #212529;
            margin-bottom: 10px;
        }

        .admin-subtitle {
            font-size: 1rem;
            color: #6c757d;
            margin-bottom: 40px;
        }

        /* Button stack */
        .btn-stack {
            display: grid;
            gap: 20px;
        }

        /* Gradient 3D button */
        .btn-primary-3d {
            background: linear-gradient(145deg, #3366ff, #6699ff);
            color: white;
            font-weight: 600;
            padding: 16px;
            border-radius: 12px;
            border: none;
            box-shadow: 0 5px 15px rgba(51, 102, 255, 0.4);
            transition: all 0.3s ease;
        }
        .btn-primary-3d:hover {
            transform: translateY(-3px);
            box-shadow: 0 10px 25px rgba(51, 102, 255, 0.5);
            background: linear-gradient(145deg, #2244cc, #5577ff);
        }

        /* Outline 3D button */
        .btn-outline-3d {
            background: #ffffff;
            border: 2px solid #3366ff;
            color: #3366ff;
            font-weight: 600;
            padding: 16px;
            border-radius: 12px;
            box-shadow: 0 5px 15px rgba(51, 102, 255, 0.2);
            transition: all 0.3s ease;
        }
        .btn-outline-3d:hover {
            background: #3366ff;
            color: white;
            transform: translateY(-3px);
            box-shadow: 0 10px 25px rgba(51, 102, 255, 0.4);
        }

        /* Optional soft animated background circles */
        .bg-circle {
            position: absolute;
            border-radius: 50%;
            opacity: 0.2;
            animation: float 6s ease-in-out infinite alternate;
            z-index: 0;
        }

        .bg-circle.circle1 { width: 200px; height: 200px; background: #ffffff; top: 10%; left: 15%; }
        .bg-circle.circle2 { width: 300px; height: 300px; background: #ffffff; top: 70%; right: 10%; }
        .bg-circle.circle3 { width: 150px; height: 150px; background: #ffffff; top: 50%; left: 60%; }

        @keyframes float {
            0% { transform: translateY(0px) translateX(0px); }
            50% { transform: translateY(-20px) translateX(10px); }
            100% { transform: translateY(0px) translateX(0px); }
        }

    </style>
</head>
<body>

    <!-- Soft background circles for subtle "live" effect -->
    <div class="bg-circle circle1"></div>
    <div class="bg-circle circle2"></div>
    <div class="bg-circle circle3"></div>

    <div class="admin-card position-relative">
        <h1 class="admin-title">Admin Dashboard</h1>
        <p class="admin-subtitle">Manage system operations and user contacts securely.</p>

        <div class="btn-stack">
            <a href="${pageContext.request.contextPath}/admin/readAllContacts" class="btn btn-primary-3d">
                View All Contacts
            </a>
            <a href="${pageContext.request.contextPath}/client/home" class="btn btn-outline-3d">
                Client Page
            </a>
            
            <a href="${pageContext.request.contextPath}/admin/addservice" class="btn btn-outline-3d">
               Add services
            </a>
            
            <a href="${pageContext.request.contextPath}/admin/readAllServices" class="btn btn-outline-3d">
               Read all services
            </a>
            
            <a href="${pageContext.request.contextPath}/admin/uploadResume" class="btn btn-outline-3d">
               Upload Resume
            </a>
            
            
        </div>
    </div>

</body>
</html>
