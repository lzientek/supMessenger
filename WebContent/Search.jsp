<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search</title>
    <%@ include file="Style/HeaderStyle.jsp" %>
</head>
<body>
<%@ include file="Partial/MenuPartial.jsp" %>
<div class="container">
    <h2>Search a contact</h2>

    <form class="form-inline" role="form" method="post" action="Search">

        <div class="form-group col-sm-4">
            <input class="form-control" style="width: 90%;" name="search" type="text" placeholder="Search..."
                   value="<c:out value="${toSearch}"/>"/>
        </div>
        <button class="btn btn-primary" type="submit">Search</button>
    </form>

    <c:if test="${not empty error}">
        <p class="alert alert-danger"><c:out value="${error}"/></p>
    </c:if>
    <c:if test="${not empty results}">
        <table class="table table-striped">
            <tr>
                <th>Username</th>
                <th></th>
            </tr>
            <c:forEach var="result" items="${results}">
                <tr>
                    <td><c:out value="${result.userName}"/></td>
                    <td>
                        <form method="post" action="AddContact">
                            <input type="hidden" name="contactId" value="<c:out value="${result.id}" />">
                            <button type="submit" class="btn btn-success">Add</button>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </c:if>
</div>

</body>
</html>
