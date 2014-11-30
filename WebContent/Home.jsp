<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home Page</title>
</head>
<body>
<fieldset>
    <legend>Login</legend>
    <form method="post" action="Login">
        <label for="username"> Username : </label>
        <input id="username" name="username"/>
        <label for="password"> Password : </label>
        <input id="password" type="password" name="password"/>
        <input type="submit"/>
        <c:if test="${not empty error}" >
        	<c:out value="${error}"/>
        </c:if>
        <br/>
        <a href="RegisterPage.jsp">Register now !</a>
    </form>
</fieldset>

<%@ include file="/Footer.jsp" %>

</body>
</html>