<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin website</title>
    <link rel="stylesheet" href="style-admin.css">
</head>
<body>
    <div class="left">
        <h1>1849 team</h1>
        <p class="welcome">Welcome ${sessionScope.name}</p>
        <form action="/PRJ321x-A3/Logout" method="post">
        <input type="submit" value="Logout">
        </form>
        <button  class="darboard">Darboard</button>
        <button class="staff">Staff Manager</button>
    </div>
    <div class="right">
        <img src="phong-canh-dep.jpg" alt="phong canh">
        <table class="table">
            <caption>Members in the team</caption>
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Student ID</th>
                    <th>Class</th>
                </tr>
            </thead>
            <tr>
                <td>1</td>
                <td>Member 1</td>
                <td>Member code 1</td>
                <td>Class 1</td>
            </tr>
            <tr>
                <td>2</td>
                <td>Member 2</td>
                <td>Member code 2</td>
                <td>Class 2</td>
            </tr>
        </table>
    </div>
</body>

</html>
    