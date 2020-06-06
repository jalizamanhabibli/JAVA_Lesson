<%--
  Created by IntelliJ IDEA.
  User: Alizaman
  Date: 06.05.2020
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="assets/css/myStyle.css" content="text/css; charset=UTF-8">
    <link rel="icon" href="image/resume.png" content="image/png">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <div class="container col-4">
        <h1 class="myFontLogin" align="center">Login</h1>
        <span style="color: red;">${param.error&&(param.email!=null&&param.password!=null)?"wrong username or password":""}</span>

        <form action="login" method="post">
            <div class="form-group">
                <label class="myFont">Email</label>
                <input type="email" class="form-control" placeholder="email@example.com" name="email">
            </div>
            <div class="form-group">
                <label class="myFont">Password</label>
                <input type="password" class="form-control" placeholder="password" name="password">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit" class="btn btn-primary" name="login">Login</button>
        </form>

    </div>
</body>
</html>
