<%-- 
    Document   : TrangCaNhan
    Created on : Sep 16, 2019, 9:33:28 PM
    Author     : duc.pt173030
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="folder.UserBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            HttpSession ss = request.getSession();
            UserBean bean = (UserBean) ss.getAttribute("concec");
            out.println("hello user: " + bean.getName());
        %>
    </body>
</html>
