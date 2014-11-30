<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>Register Page</title>
</head>
<body>
<fieldset>
    <legend>Register</legend>
    <form method="post" action="Register">

        <label for="username"> Username : </label>
        <input id="username" name="username"/><br/>

        <label for="password"> Password : </label>
        <input id="password" type="password" name="password"/><br/>

        <label for="password2"> Re-enter your password : </label>
        <input id="password2" type="password" name="password2"/><br/>

        <label for="mail"> mail : </label>
        <input id="mail" name="mail"/><br/>

        <input type="submit"/>
    </form>
</fieldset>

<%@ include file="/Partial/FooterPartial.jsp" %>

</body>
</html>