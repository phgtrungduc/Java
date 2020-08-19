<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="folder.UserBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <title>Welcome Baby</title>
    </head>
    <body>
        <p>You are successfully logged in!</p>
        <%
            UserBean bean = (UserBean) request.getAttribute("concec");
            out.print("Welcome, " + bean.getName());
        %>
    </body>
</html>