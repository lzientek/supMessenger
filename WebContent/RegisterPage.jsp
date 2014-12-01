<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Register Page</title>
    <%@ include file="Style/HeaderStyle.jsp" %>
</head>
<body>
<%@ include file="Partial/MenuPartial.jsp" %>
<div class="container">

	 <c:if test="${not empty error}">
	        <p class="bg-danger bg"><c:out value="${error}"/></p>
	 </c:if>
	
	<fieldset>
	    <legend>Register</legend>
	    <form class="form-horizontal" role="form" method="post" action="Register">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label"> Username : </label>
            	<div class="col-sm-5">
                	<input class="form-control" id="username" name="username"/>
            	</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 control-label"> password : </label>
            	<div class="col-sm-5">
                	<input class="form-control" id="password" type="password" name="password"/>
            	</div>
			</div>
			
			<div class="form-group">
				<label for="password2" class="col-sm-2 control-label"> password : </label>
            	<div class="col-sm-5">
                	<input class="form-control" id="password2" type="password" name="password2"/>
            	</div>
			</div>
			
			<div class="form-group">
				<label for="mail" class="col-sm-2 control-label"> mail : </label>
            	<div class="col-sm-5">
                	<input class="form-control" id="mail" type="text" name="mail"/>
            	</div>
			</div>

	     	<div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input class="btn btn-default" type="submit" value="Register"/>
            </div>
        </div>
	    </form>
	</fieldset>
</div>
 
</body>
</html>