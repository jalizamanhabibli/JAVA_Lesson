<%@ page import="com.company.entity.User" %>
<%@ page import="com.company.main.Context" %>
<%@ page import="com.company.entity.Country" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Alizaman
  Date: 24.03.2020
  Time: 00:09
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>User Details Page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/myStyle.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
    <link rel="icon" href="image/resume.png">

</head>
<%
    User user = (User) request.getAttribute("user");
    List<Country> countryList = Context.instanceCountryDao().getAllCountry();
%>
<body>
<div class="container">
    <div class="col-6 m-auto">
        <form action="/resume/" method="post">
            <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
            <div class="form-group">
                <label class="myFont">Name: </label>
                <input type="text" class="form-control" name="name" value="<%=user.getName()%>">
            </div>
            <div class="form-group">
                <label class="myFont">Surname: </label>
                <input type="text" class="form-control" name="surname" value="<%=user.getSurname()%>">
            </div>
            <div class="form-group">
                <label class="myFont">Email: </label>
                <input type="text" class="form-control" name="email" value="<%=user.getEmail()%>">
            </div>
            <div class="form-group">
                <label class="myFont">Number: </label>
                <input type="text" class="form-control" name="number" value="<%=user.getNumber()%>">
            </div>
            <div class="form-group">
                <label class="myFont">Profile Description: </label>
                <textarea class="form-control" rows="3"
                          name="profiledescription"><%=user.getProfileDescription()%></textarea>
            </div>
            <div class="form-group">
                <label class="myFont">Address: </label>
                <input type="text" class="form-control" name="address" value="<%=user.getAddress()%>">
            </div>
            <div class="form-group">
                <label class="myFont">Birthday: </label>
                <input type="date" class="form-control" name="birthday" value="<%=user.getBirthDate()%>">
            </div>
            <div class="form-group">
                <label class="myFont">Birthplace: </label>
                <select class="form-control" name="birthplace">
                    <%for (Country country : countryList) {%>
                    <option value="<%=country.getId()%>"<%
                        if (country.getId() == user.getBirthPlace().getId()) {
                    %>
                            selected
                            <%
                                }
                            %>><%=country.getName()%>
                    </option>
                    <%}%>
                </select>
            </div>
            <div class="form-group">
                <label class="myFont">Nationality: </label>
                <select class="form-control" name="nationality">
                    <%for (Country country : countryList) {%>
                    <option value="<%=country.getId()%>"<%
                        if (country.getId() == user.getNationality().getId()) {
                    %>
                            selected
                            <%
                                }
                            %>><%=country.getNationality()%>
                    </option>
                    <%}%>
                </select>
            </div>
            <button type="submit" class="btn btn-secondary float-right" name="action" value="edit" style="margin-bottom: 10px;">
                <i class="fas fa-edit" style="font-size: 20px;"></i>
            </button>
        </form>
    </div>
</div>
</body>
</html>
