<%-- 
    Document   : FirstPage
    Created on : Sep 10, 2019, 5:12:52 PM
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
    <h1>Điền thông tin vào mẫu sau</h1>
        <form action="Module" method="get">
            First Name :<input type="text" name="firstname"><br>
            Last Name :<input type="text" name="lastname"><br>
            UserName :<input type="text" name="username"><br>
            Password :<input type="password" name="password"><br>
            <input type="submit" value="OK">
        </form>
    </body>
</html>
