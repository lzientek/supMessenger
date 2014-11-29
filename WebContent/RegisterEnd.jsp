<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>Insert title here</title>
</head>
<body>
<c:if test="${success eq true}">
			<p> Successfull registred ! </p>
		</c:if>
<c:if test="${success eq false}">
			<p> Register Failed !</p><br/>

    <p> Error : <c:out value="${error.message}"></c:out></p>
</c:if>
		<br/><br/>
		<a href="Home.jsp" >Return home page</a>
</body>
</html>