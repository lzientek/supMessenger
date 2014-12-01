<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ include file="Style/HeaderStyle.jsp" %>

    <title>Home Page</title>
    <script type="application/javascript">
        function scrollDown() {
            $("#scrollDiv").scrollTop($("#scrollDiv").prop("scrollHeight"));

        }
    </script>
</head>
<body onload="scrollDown()">
<%@ include file="Partial/MenuPartial.jsp" %>
<div class="container">

    <div class="col-md-4">
        <div class="row">
            <div class="col-md-11" style="height: 600px;overflow-y: auto;">
                <%-- list de contact --%>
                    <div class="list-group">
                        <c:forEach items="${user.contactsBinding}" var="contact">
                            <a class="list-group-item <c:if test="${selectedContact.id == contact.contact.id}">active</c:if>"
                               href="Chat?contactId=<c:out value="${contact.contact.id}"/>">
                                <h4><c:out value="${contact.contact.userName}"/>
                                </h4>

                                <p><c:out value="${contact.contact.mail}"/></p>

                            </a>
                        </c:forEach>
                    </div>
            </div>
        </div>
    </div>


    <div class="col-md-7">
        <c:if test="${not empty sendError}">
            <p class="alert alert-danger"><c:out value="${sendError}"/></p>
        </c:if>
        <%-- list de message --%>
        <div class="row">
            <div class="col-sm-11" style="height: 400px;overflow-y: auto;" id="scrollDiv">
                <c:if test="${not empty error}">
                    <p class="alert alert-warning"><c:out value="${error}"/></p>
                </c:if>
                <c:if test="${not empty messages}">
                    <c:forEach items="${messages}" var="message">
                        <div class="row">
                            <h2><c:out value="${message.transmitter.userName}"/></h2>

                            <p><c:out value="${message.message}"/></p>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
        <div class="row">
            <form class="form-horizontal" role="form" action="" method="post">
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
    </div>
</div>


</body>
</html>