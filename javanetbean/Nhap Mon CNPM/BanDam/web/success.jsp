<%-- 
    Document   : success
    Created on : Sep 30, 2019, 6:42:19 PM
    Author     : duc.pt173030
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="module.userpass"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Bạn vừa đăng nhập thành công
        <%
            session = request.getSession();
            String name = (String )session.getAttribute("name");
            out.print("hello " +name);
        %>
    </body>
</html>
