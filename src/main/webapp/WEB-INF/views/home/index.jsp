<%-- 
    Document   : index
    Created on : Nov 28, 2018, 12:06:02 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${requestScope.name}</h1>
        
        <ul>
            <c:forEach var="user" items="${requestScope.users}">
                <li>${user.userName}</li>
            </c:forEach>
        </ul>
    </body>
</html>
