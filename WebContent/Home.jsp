<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ include file="Style/HeaderStyle.jsp" %>

    <title>Home Page</title>
</head>
<body>
<%@ include file="Partial/MenuPartial.jsp" %>

<c:if test="${empty sessionScope.userId}">
    <%@ include file="Partial/FooterPartial.jsp" %>
</c:if>
<c:if test="${not empty sessionScope.userId}">
    <%@ include file="Partial/FooterConnectedPartial.jsp" %>
</c:if>
</body>
</html>