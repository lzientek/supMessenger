<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <%@ include file="/Style/HeaderStyle.jsp" %>
</head>
<body>
<%@ include file="/Partial/MenuPartial.jsp" %>
<fieldset>
    <legend>Login</legend>
    <form method="post" action="Login">
        <label for="username"> Username : </label>
        <input id="username" name="username"/>
        <label for="password"> Password : </label>
        <input id="password" type="password" name="password"/>
        <input type="submit"/>
        <c:if test="${not empty error}">
            <c:out value="${error}"/>
        </c:if>
        <br/>
        <a href="RegisterPage.jsp">Register now !</a>
    </form>
</fieldset>
</body>
</html>
