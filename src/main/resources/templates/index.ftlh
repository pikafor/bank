<!doctype html>
<html lang="en" xmlns:th="http://thymeleaf.org">
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
            border: 1px solid darkgray;
            padding: 20px;
            background-color: #a49a9a;
            border-radius: 10px;
        }

        .datatable {
            margin: 20px auto;
            border-collapse: collapse;
            border: 1px solid #ccc;
        }

        .datatable th, .datatable td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        .datatable th {
            background-color: #f2f2f2;
        }

        .form-btn {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .form-btn input[type="submit"] {
            padding: 10px 20px;
            background-color: #836f6f;
            color: white;
            border: none;
            cursor: pointer;
        }

        .form-btn input[type="submit"]:hover {
            background-color: #836f6f;
        }

        .link {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .link a {
            color: #453d3d;
            text-decoration: none;
        }
        .td {
            background: white;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>профиль</h1>
    <p>${people.getFirstName()} ${people.getSecondName()}</p>

    <table class="datatable">
        <tr>
            <th>счет</th>
            <th>дата создания</th>
            <th>тип</th>
        </tr>
        <#list bills as bill>
            <tr>
                <td class="td">${bill.money}</td>
                <td class="td">${bill.createDate}</td>
                <td class="td">${bill.type}</td>
            </tr>
        </#list>
    </table>

    <div class="form-btn">
        <form action="create/has_create_bill/debit/${people.id}" method="post">
            <input type="submit" value="создать новую дебетовую карту">
        </form>
    </div>

    <div class="form-btn">
        <form action="create/has_create_bill/credit/${people.id}" method="post">
            <input type="submit" value="создать новую кредитную карту">
        </form>
    </div>

    <div class="link">
        <a href="home">на главную</a>
    </div>
</div>
</body>
</html>