<%@ page import="org.example.project_1.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.project_1.repo.UserRepo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Gurp</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }
        nav {
            background-color: #444;
            padding: 10px;
            text-align: center;
        }
        nav a {
            color: #fff;
            text-decoration: none;
            margin: 0 10px;
        }
        .product {
            background-color: #fff;
            padding: 20px;
            margin: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .product img {
            max-width: 100%;
            border-radius: 5px;
        }
        .product h2 {
            margin-top: 0;
        }
        .product p {
            margin-bottom: 0;
        }
    </style>
</head>
<body>
<header>
    <h1>Student</h1>
</header>
<nav>
    <a href="http://localhost:8080/login/Login.jsp">Login</a>
    <a href="http://localhost:8080/index.jsp">Home</a>
    <a href="http://localhost:8080/user/Gurp.jsp">Gurp</a>
    <a href="http://localhost:8080/user/Student.jsp">Student</a>
    <a href="http://localhost:8080/user/StudentAdd.jsp">StudentAdd</a>

</nav>

<div class="product" id="productList">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">FirstName</th>
            <th scope="col">LastName</th>
            <th scope="col">Email</th>
            <th scope="col">Password</th>
            <th scope="col">Group</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <%
            UserRepo userRepo = new UserRepo();
            List<User> students = userRepo.findAll();
            System.out.println(students);
            int n = 1;
            for (User student : students) {
        %>
        <tr>
            <th scope="row"><%=n++%></th>
            <td><%=student.getFirstName()%></td>
            <td><%=student.getLastName()%></td>
            <td><%=student.getEmail()%></td>
            <td><%=student.getPassword()%></td>
            <td><%=student.getGroup().getName()%></td>
            <td>
                <a href="http://localhost:8080/user/StudentEdit.jsp?id=<%=student.getId()%>" id="edit">Edit</a>
                <a href="${pageContext.request.contextPath}/userDelete?id=<%=student.getId()%>" id="delete">Delete</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>
