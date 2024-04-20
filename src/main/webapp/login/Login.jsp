<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email va Parol Forma</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-container input[type="text"],
        .form-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        .form-container input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
        .form-container input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .form-container p {
            text-align: center;
            margin-top: 15px;
        }
        .form-container p a {
            color: #007bff;
            text-decoration: none;
        }
        .form-container p a:hover {
            text-decoration: underline;
        }
        .error-message {
            color: red;
            font-size: 0.8rem;
            margin-top: -10px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Kirish</h2>
    <form action="${pageContext.request.contextPath}/userLogin" method="get">
        <label for="email"></label><input type="text" id="email" name="email" placeholder="Email" required><br>
        <span id="email-error" class="error-message"></span><br>
        <label for="password"></label><input type="password" id="password" name="password" placeholder="Parol" required><br>
        <span id="password-error" class="error-message"></span><br>
        <input type="submit" value="Kirish">
    </form>
</div>
</body>
</html>