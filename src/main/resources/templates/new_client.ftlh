<!doctype html>
<html lang="en" xmlns:th="http://thymeleaf.org">
<head>
    <meta charset="utf-8">
    <title>title</title>
    <style>
        body {
            background-color: #faf3f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #a49a9a;
            padding: 20px;
            border-radius: 10px;
        }

        input[type="text"] {
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #836f6f;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }

        a {
            display: block;
            margin-top: 10px;
            color: #453d3d;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="has_create_client" method="post">
        <input type="text" name="firstName"><br>
        <input type="text" name="secondName"><br>
        <input type="submit" value="add">
    </form>

    <a href="../home">на главную</a>
</div>
</body>
</html>