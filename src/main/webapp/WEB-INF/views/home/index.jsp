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
        <h1>Welcome ${requestScope.name}</h1>
        <div>
            <c:if test="${param.error !=null}">
                <div style="color:red;font-weight: bold">
                    Invalid Username/Password Please Try Again !!
                </div>
            </c:if>
            <form action="" method="post">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" required="required"/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" required="required"/>
                </div>
                <button type="submit">Login</button>
            </form>
        </div>
    </body>
</html>
