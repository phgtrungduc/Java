<%-- 
    Document   : SecondPage
    Created on : Sep 10, 2019, 5:19:05 PM
    Author     : duc.pt173030
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Module.Module" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chào mừng</title>
    </head>
    <body>
        <p>You are successfully logged in!</p>
        <%
            Module a = (Module) request.getAttribute("abc");
            String firstname = a.getFirstName();
            String lastname = a.getLastName();
            String pass = a.getPassword();
            String username = a.getUserName();
//            PrintWriter out = response.getWriter();
            out.println("Welcome to new user, " + firstname + " " + lastname);


        %>
        <br>
        <%            out.println("Username: " + username);
        %>
        <br>
        <%
            out.println("Pass: " + pass);
        %>
    </body>
</html>
