<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profile</title>
<%@ include file="Style/HeaderStyle.jsp" %>
</head>
<body>
<%@ include file="Partial/MenuPartial.jsp" %>
<div class="container">
	
	
	
	<img alt="Mon Gravatar !!! " src="${urlGravatar }" >
	<br/>
	
	<form class="form-horizontal" role="form" method="post" action="ModifProfile">
	
		<label for="username" class="col-sm-2 control-label"> Username : </label>
		<div class="col-sm-5">
               	<input readonly="readonly" class="form-control" type="text" id="username" name="username" value="${username}" />
       	</div>
       	<br/>
		
		<label for="password" class="col-sm-2 control-label"> Password : </label>
		<div class="col-sm-5">
               	<input class="form-control" type="password" id="password" name="password" value="${password}"  />
       	</div>
       	<br/>
       	
       	<label for=mail class="col-sm-2 control-label"> E-mail : </label>
		<div class="col-sm-5">
               	<input class="form-control" type="text" id="mail" name="mail" value="${mail}" />
       	</div>
       	<br/>
       	
       	<div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input class="btn btn-default" type="submit" value="ModifProfile"/>
            </div>
    	</div>
    	<br/>
    	
	</form>
	

</div>
</body>
</html>