<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <%@ include file="Style/HeaderStyle.jsp" %>

    <title>Home Page</title>
</head>
<body>
<%@ include file="Partial/MenuPartial.jsp" %>
<div class="container">
    <p>Welcome to SupMessaging ! The new online and most famous messaging system.</p>

    <div class="row">
        <div class="col-md-6">
            <h3>Send messages</h3>

            <p>Total send messages : <c:out value=" ${nbPost}"/></p>
            <h4>Number of messages send per day:</h4>

            <div id="messagePerDay" style="height: 250px;"></div>

        </div>

        <div class="col-md-6">
            <h3>Users</h3>

            <p>Total users : <c:out value=" ${nbUser}"/></p>
            <h4>Inscription per month:</h4>

            <div id="userPerMonth" style="height: 250px;"></div>

        </div>
    </div>


</div>

<%-- script pour graphique --%>
<script type="application/javascript">
    new Morris.Line({
        element: 'messagePerDay',
        data: [
            <%-- on génère le js depuis la bdd --%>
            <c:if test="${not empty messagePerDay}" >
            <c:forEach items="${messagePerDay}" var="msg">
            { date: "<fmt:formatDate  pattern="yyyy-MM-dd"  value="${msg[0]}"/>", value: <c:out value="${msg[1]}" /> },
            </c:forEach>
            </c:if>
        ],
        xkey: 'date',
        ykeys: ['value'],
        labels: ['Value']
    });
    new Morris.Bar({
        element: 'userPerMonth',
        data: [
            <%-- on génère le js depuis la bdd --%>
            <c:if test="${not empty userPerMonth}" >
            <c:forEach items="${userPerMonth}" var="usr">
            { date: "<fmt:formatDate  pattern="yyyy-MM"  value="${usr[0]}"/>", value: <c:out value="${usr[1]}" /> },
            </c:forEach>
            </c:if>
        ],
        xkey: 'date',
        ykeys: ['value'],
        labels: ['Inscription']
    });
</script>

</body>
</html>