<%@ page import="org.example.project_1.entity.Group" %>
<%@ page import="org.example.project_1.repo.GroupRepo" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Region</title>
    <style>
        /* Global styles */
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
        /* Form container styles */
        .form-container {
            background-color: #fff;
            padding: 20px;
            margin: 10px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
        }
        .form-container input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            padding: 10px 20px;
            transition: background-color 0.3s;
        }
        .form-container input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<header>
    <h1>Add Student</h1>
</header>
<div class="container">
    <!-- Product list goes here -->
</div>
<!-- Add Region form -->
<div class="form-container">
    <form action="${pageContext.request.contextPath}/UserAdd" method="get">
        <label for="lastname">LastName:</label><br>
        <input type="text" id="lastname" name="lastName" required><br><br>
        <label for="firstname">FirstName:</label><br>
        <input type="text" id="firstname" name="firstName" required><br><br>
        <label for="country">Email:</label><br>
        <input type="text" id="country" name="email" required><br><br>
        <label for="region">Password:</label><br>
        <input type="text" id="region" name="password" required><br><br>
        <label for="groupId"></label>
        <select name="groupId" id="groupId">
            <option value="" selected disabled> Group</option>
            <% for (Group category : GroupRepo.findAll()) { %>
            <option value="<%=category.getId()%>">
                <%= category.getName() %>
            </option>
            <%}%>
        </select>
        <input type="submit" value="Add">
    </form>
</div>
</body>
</html>
