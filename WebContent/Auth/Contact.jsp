<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Contact</title>
    <%@ include file="/Style/HeaderStyle.jsp" %>
</head>
<body>
<%@ include file="/Partial/MenuPartial.jsp" %>
<div class="container">
    <c:if test="${success}">
        <p class="bg-success bg">Message send!!!</p>
    </c:if>
    <c:if test="${not empty error}">
        <p class="bg-danger bg">Error!! <c:out value="${error}"/></p>
    </c:if>
    <form class="form-horizontal" role="form" action="Contact" method="post">

        <div class="form-group">
            <label for="message" class="col-sm-2 control-label">Message</label>

            <div class="col-sm-7">
                <textarea rows="4" class="form-control" name="message" id="message"
                          placeholder="Message..."> </textarea>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Send</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>