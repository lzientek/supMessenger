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
    <h2 class=" col-sm-offset-1">Last messages</h2>
    <c:if test="${not empty result}">
        <c:forEach items="${result}" var="message">
            <c:set var="contact" value="${message.recipient}"/>
            <c:set var="isRecipient" value="false"/>
            <c:if test="${message.recipient.id == sessionScope.userId}">
                <c:set var="contact" value="${message.transmitter}"/>
                <c:set var="isRecipient" value="true"/>
            </c:if> <c:set var="isRecipient" value="false"/>


            <div class="row">
                <div class="well col-sm-offset-2 col-sm-8">
                    <div class="col-sm-1">
                        <img height="60" width="60" src="<c:out value="${contact.gravatarUrl}"/>" alt="">
                    </div>
                    <div class="col-sm-8">
                        <h4><a href="Chat?contactId=<c:out value="${contact.id}"/>">
                            <c:out value="${message.transmitter.userName}"/> &gt;
                            <c:out value="${message.recipient.userName}"/>
                        </a>
                        </h4>

                        <p><c:out value="${message.message}"/></p>
                        <time datetime="<c:out value="${message.sendDate}" />">
                            <c:out value="${message.sendDate}"/>
                        </time>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${empty result}">
        <p class="alert alert-info">No message.</p>
    </c:if>
</div>
</body>
</html>