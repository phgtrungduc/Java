<%-- 
    Document   : Login
    Created on : Sep 15, 2019, 11:54:53 PM
    Author     : duc.pt173030
--%>

<%@page import="java.util.Scanner"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name = (String)request.getAttribute("leuleu");
            out.print(name);
        %>
    </body>
</html>
