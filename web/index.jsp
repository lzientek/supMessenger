<%@ page import="com.supinfo.supMessaging.entities.Message" %>
<%@ page import="javax.persistence.Persistence" %>
<%@ page import="javax.persistence.EntityManagerFactory" %>
<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 27/11/2014
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <%
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("My-PU");
      new Message();
      emf.close();
  %>
  </body>
</html>
