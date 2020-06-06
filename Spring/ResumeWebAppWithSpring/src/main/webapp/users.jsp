<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
    Document   : skill
    Created on : Mar 22, 2020, 5:39:21 PM
    Author     : Alizaman
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users List Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myStyle.css" content="text/css; charset=UTF-8">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link rel="icon" href="${pageContext.request.contextPath}/image/resume.png" content="image/png">
    <script src="${pageContext.request.contextPath}/assets/js/users.js" content="javascript"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>

<%
    int i = 0;
%>
<body>

<div class="container">
    <h5 align="center">Welcome ${loggedInUser.name}</h5>

    <form action="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-secondary" style="float: right;">Logout</button>
    </form>

    <div class="col-4">
        <form:form action="/resume/search" method="get" modelAttribute="userDto">
            <div class="form-group">
                <label class="myFont">Name: </label>
                <form:input path="name" class="form-control" placeholder="Name"/>
            </div>
            <div class="form-group">
                <label class="myFont">Surname: </label>
                <form:input path="surname" class="form-control" placeholder="Surname"/>
            </div>
            <form:button type="submit" class="btn btn-primary">
                <i class="fas fa-search"> Search</i>
            </form:button>
        </form:form>
    </div>
</div>
<div class="container" style="margin-top: 5px;">
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Email</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td scope="col"><%=++i%>
                </td>

                <td scope="col">${user.name} </td>

                <td scope="col">${user.surname} </td>

                <td scope="col">${user.email} </td>

                <td scope="col">
                    <div class="row">

                        <button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal"
                                onclick="setId(${user.id})">
                            <i class="fas fa-trash-alt"></i>
                        </button>

                        <form action="userDetails" method="post">
                            <button type="submit" class="btn btn-warning" style="margin-left: 10px;">
                                <i class="fas fa-info-circle">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input type="hidden" name="id" value="${user.id}">
                                </i>
                            </button>
                        </form>

                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Delete User</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="deleteUser" method="post">
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
