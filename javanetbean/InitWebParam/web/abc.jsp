<%-- 
    Document   : abc
    Created on : Sep 15, 2019, 9:54:51 AM
    Author     : duc.pt173030
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "javax.servlet.ServletContext" %>
<%@page import= "javax.servlet.ServletConfig" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%         
            ServletContext a = getServletContext();
            String song = a.getInitParameter("song");
            out.print(song);
            ServletConfig cf = getServletConfig();
            String song2 = cf.getInitParameter("song");
            out.print(song);
        %>
        <br>
        
    </body>
</html>
