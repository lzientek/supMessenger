<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br/>
<br/>
<br/>

<fieldset>
	<legend>Info</legend>
	<p>
		Numbers of User : 
		<c:if test="${empty nbUser}" >	
        	0 	
	    </c:if>
	    <c:if test="${not empty nbUser}" >	
       	  <c:out value=" ${nbUser}"/>  	
	    </c:if>
	</p>
	<br/>
	<p>
		Numbers of post : 
		<c:if test="${empty nbPost}" >	
        	 0	
	    </c:if>
	    <c:if test="${not empty nbPost}" >	
      	  <c:out value=" ${nbPost}"/>  	
	    </c:if>
	</p>
	<br/>	
</fieldset>

<br/>
<br/>
<br/>

<p>
    <a href="../HomeConnected.jsp">Home</a>

<p>