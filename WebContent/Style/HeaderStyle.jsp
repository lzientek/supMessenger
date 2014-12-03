<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<c:if test="${ fn:contains(requestScope['javax.servlet.forward.servlet_path'],'/Auth') }">
    <link rel="stylesheet" href="../Style/style.css">
</c:if>
<c:if test="${ not fn:contains(requestScope['javax.servlet.forward.servlet_path'],'/Auth') }">
    <link rel="stylesheet" href="Style/style.css">
</c:if>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" abp="49"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>