<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User Details Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/myStyle.css" content="text/css; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.7/css/all.css">
        <link rel="icon" href="image/resume.png">

    </head>
    <body>
        <div class="container">
            <div class="col-6 m-auto">
                <form:form action="/resume/" method="post" modelAttribute = "updateUserDto">
                    <form:hidden  path = "id"/>
                    <div class="form-group">
                        <label class="myFont">Name: </label>
                        <form:input path = "name" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="myFont">Surname: </label>
                        <form:input path = "surname" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="myFont">Email: </label>
                        <form:input path="email" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="myFont">Number: </label>
                        <form:input path="number" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="myFont">Profile Description: </label>
                        <form:textarea path = "profileDescription" class="form-control" rows="3" cols="15"/>
                    </div>
                    <div class="form-group">
                        <label class="myFont">Address: </label>
                        <form:input path = "address" type="text" class="form-control"/>
                    </div>
                    <div class="form-group">
                        <label class="myFont">Birthday: </label>
                        <form:input path = "birthDate" type="date" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label class="myFont">Birthplace: </label>
                        <form:select path="birthplaceId" class="form-control">
                            <c:forEach items="${countries}" var="country">
                                <option value="${country.id}" ${country.id == updateUserDto.birthplaceId.id ? 'selected="true"' : ''}> ${country.name} </option>
                            </c:forEach>
                        </form:select>
                    </div>

                    <div class="form-group">
                        <label class="myFont">Nationality: </label>
                        <form:select path = "nationalityId" class="form-control">
                            <c:forEach items="${countries}" var="country">
                                <option value="${country.id}" ${country.id == updateUserDto.nationalityId.id ? 'selected="true"' : ''}> ${country.nationality} </option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <button type="submit" class="btn btn-secondary float-right" style="margin-bottom: 5px;">
                        <i class="fas fa-edit" style="font-size: 20px"></i>
                    </button>
                </form:form>
            </div>
        </div>
    </body>
</html>
