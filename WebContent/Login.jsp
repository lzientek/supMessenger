<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="Style/HeaderStyle.jsp" %>
</head>
<body>
<%@ include file="Partial/MenuPartial.jsp" %>
<div class="container">
    <h2>Login</h2>
    <c:if test="${not empty error}">
        <p class="bg-danger bg"><c:out value="${error}"/></p>
    </c:if>
    <form class="form-horizontal" role="form" method="post" action="Login">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label"> Username : </label>

            <div class="col-sm-5">
                <input class="form-control" id="username" name="username"/>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label"> Password : </label>

            <div class="col-sm-5">
                <input class="form-control" id="password" type="password" name="password"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input class="btn btn-default" type="submit" value="Login"/>
            </div>
        </div>

        <a href="Register">Register now !</a>
    </form>
</div>
</body>
</html>
