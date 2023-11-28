<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>title</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #faf3f0;
        }

        .container {
            text-align: center;
            padding: 20px;
            border: 1px solid #836f6f;
            background-color: #a49a9a;
            border-radius: 10px;
        }

        form {
            text-align: center;
        }

        input[type="text"] {
            margin-bottom: 10px;
        }

        input[type="submit"] {
            background-color: #453d3d;
            color: #faf3f0;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 10px;
            color: #453d3d;
            text-decoration: none;
        }

        a:hover {
            color: #faf3f0;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="search" method="post">
        <input type="text" name="clientId">
        <br>
        <input type="submit" value="search">
    </form>
    <a href="create/client">новый пользователь</a>
</div>
</body>
</html>