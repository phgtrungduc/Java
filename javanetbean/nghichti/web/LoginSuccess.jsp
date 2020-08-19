<%-- 
    Document   : LoginSuccess
    Created on : Sep 11, 2019, 10:15:09 PM
    Author     : duc.pt173030
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="XuLy.XuLy"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Baby</title>
    </head>
    <body>
        <%
            XuLy xl = new XuLy();
            xl = (XuLy) request.getAttribute("a");
            String name = xl.getName();
            String pass = xl.getPassword();
            out.print("Hello "+name);
        %>
        <br>
        <%
            out.print("Pass của mày là "+pass);
        %>
    </body>
</html>
