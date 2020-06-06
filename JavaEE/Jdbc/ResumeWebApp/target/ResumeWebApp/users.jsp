<%-- 
    Document   : skill
    Created on : Mar 22, 2020, 5:39:21 PM
    Author     : Alizaman
--%>

<%@page import="java.util.List" %>
<%@ page import="com.company.entity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users List Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/myStyle.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link rel="icon" href="image/resume.png">
    <script src="assets/js/users.js"></script>
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
    User user=(User) session.getAttribute("loggedInUser");
    List<User> users = (List<User>) request.getAttribute("users");
%>
<body>

<div class="container">
    <h5 align="center"><%="Welcome "+user.getName()%></h5>

    <form action="logout" method="post">
        <button type="submit" class="btn btn-secondary" style="float: right;">Logout</button>
    </form>

    <div class="col-4">
        <form action="/resume/" method="post">
            <div class="form-group">
                <label class="myFont">Name: </label>
                <input type="text" class="form-control" name="name" placeholder="Name">
            </div>
            <div class="form-group">
                <label class="myFont">Surname: </label>
                <input type="text" class="form-control" name="surname" placeholder="Surname">
            </div>
            <button type="submit" class="btn btn-primary" name="search" value="Search">
                <i class="fas fa-search"> Search</i>
            </button>
        </form>
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
        <%for (int i = 0; i < users.size(); i++) {%>
        <tr>
            <td scope="col"><%=(i + 1)%>
            </td>

            <td scope="col"><%=users.get(i).getName()%>
            </td>

            <td scope="col"><%=users.get(i).getSurname()%>
            </td>

            <td scope="col"><%=users.get(i).getEmail()%>
            </td>

            <td scope="col">
                <div class="row">

                    <button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal"
                            onclick="setId(<%=users.get(i).getId()%>)">
                        <i class="fas fa-trash-alt"></i>
                    </button>

                    <form action="userDetails" method="post">
                        <button type="submit" class="btn btn-warning" name="action" value="info"
                                style="margin-left: 10px;">
                            <i class="fas fa-info-circle">
                                <input type="hidden" name="id" value="<%=users.get(i).getId()%>">
                            </i>
                        </button>
                    </form>

                </div>
            </td>
        </tr>
        <%}%>
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
                <form action="index.html" method="post">
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger" name="action" value="delete">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
