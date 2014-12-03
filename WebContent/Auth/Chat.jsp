<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ include file="../Style/HeaderStyle.jsp" %>

    <title>Home Page</title>
    <script type="application/javascript">
        function scrollDown() {
            $("#scrollDiv").scrollTop($("#scrollDiv").prop("scrollHeight"));

        }
    </script>
</head>
<body onload="scrollDown()">
<%@ include file="../Partial/MenuPartial.jsp" %>
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
            <div class="col-sm-11">
                <c:if test="${not empty error}">
                    <p class="alert alert-warning"><c:out value="${error}"/></p>
                </c:if>
                <c:if test="${not empty messages}">


                    <div class="panel panel-default">
                        <div class="panel-body msg_container_base" id="scrollDiv">
                            <c:forEach items="${messages}" var="message">
                                <c:if test="${message.transmitter.id == user.id}">
                                    <%-- message envoyé !--%>

                                    <div class="row msg_container base_sent">
                                        <div class="col-md-10 col-xs-10 msg_no_marge-right">
                                            <div class="messages msg_sent">

                                                <p><c:out value="${message.messageHtml}"/></p>
                                                <time datetime="2009-11-13T20:00"><c:out
                                                        value="${message.transmitter.userName}"/> &#8226; <c:out
                                                        value="${message.sendDate}"/>
                                                </time>
                                            </div>
                                        </div>
                                        <div class="col-md-2 col-xs-2 avatar msg_no_marge-left">
                                            <img class=" img-responsive "
                                                 src="<c:out value="${message.transmitter.gravatarUrl}"/>"
                                                    >
                                        </div>
                                    </div>
                                </c:if>
                                <c:if test="${message.transmitter.id != user.id}">
                                    <%-- message recu !--%>
                                    <div class="row msg_container base_receive">
                                        <div class="col-md-2 col-xs-2 avatar msg_no_marge-right">
                                            <img class=" img-responsive "
                                                 src="<c:out value="${message.transmitter.gravatarUrl}"/>"
                                                    >
                                        </div>
                                        <div class="col-md-10 col-xs-10 msg_no_marge-left">
                                            <div class="messages msg_receive">
                                                <p><c:out escapeXml="false" value="${message.messageHtml}"/></p>
                                                <time datetime="2009-11-13T20:00"><c:out
                                                        value="${message.transmitter.userName}"/> &#8226; <c:out
                                                        value="${message.sendDate}"/>
                                                </time>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>

                            </c:forEach>
                        </div>
                    </div>


                </c:if>
            </div>
        </div>
        <div class="row">
            <form class="form-horizontal" role="form" action="" method="post">
                <div class="col-sm-11">

                    <div class="input-group input-group-lg" style="height: 100px;">

                        <textarea style="height: 100px;" rows="2" class="form-control" name="message" id="message"
                                  placeholder="Message..."> </textarea>
                        <span style="height: 100px;" class="input-group-btn">
                            <button style="height: 100px;" type="submit" class="btn btn-primary">Send</button>
                            </span>
                    </div>

                </div>

            </form>
        </div>
    </div>
</div>


</body>
</html>