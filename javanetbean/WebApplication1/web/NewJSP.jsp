<%-- 
    Document   : NewJSP
    Created on : Sep 3, 2019, 10:14:30 PM
    Author     : duc.pt173030
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<h1>Hello <%= request.getParameter("username") %></h1>
</body>
</html>