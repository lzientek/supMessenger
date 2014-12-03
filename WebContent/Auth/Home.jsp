<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ include file="../Style/HeaderStyle.jsp" %>

    <title>Home Page</title>
</head>
<body>
<%@ include file="../Partial/MenuPartial.jsp" %>
<div class="container">
    <c:forEach items="${result}" var="message">
        <c:set var="contact" value="${message.value.recipient}"/>
        <c:set var="isRecipient" value="false"/>
        <c:if test="${message.value.recipient.id == sessionScope.userId}">
            <c:set var="contact" value="${message.value.transmitter}"/>
            <c:set var="isRecipient" value="true"/>
        </c:if> <c:set var="isRecipient" value="false"/>


        <div class="row">
            <h4><a href="Chat?contactId=<c:out value="${contact.id}"/>">
                <c:out value="${message.value.transmitter.userName}"/> &gt;
                <c:out value="${message.value.recipient.userName}"/>
            </a>
            </h4>

            <p><c:out value="${message.value.message}"/></p>
        </div>
    </c:forEach>
</div>
</body>
</html>