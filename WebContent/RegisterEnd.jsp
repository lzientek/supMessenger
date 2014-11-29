<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:if test="${sucess eq true}">
			<p> Successfull registred ! </p>
		</c:if>
		<c:if test="${sucess eq false}">
			<p> Register Failed !</p><br/>
			<p> Error : <c:out value="${Error}"></c:out> </p>
		</c:if>
		<br/><br/>
		<a href="Home.jsp" >Return home page</a>
</body>
</html>