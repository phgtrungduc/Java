<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.module.connection.KetNoi" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
    </head>
    <body>
        <h1>WELCOME</h1>
        
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>List of Product</h2></caption>
                <tr>
                    <th>Number</th>
                    <th>Name</th>
                
                <th>Quantity</th>
                <th>Price</th>
                </tr>
                <%
                KetNoi conn = new KetNoi();
                ResultSet rs = conn.selectData("select name, quantity, price from Product");
                int count = 1;
                while (rs.next()) {
                    //writer.println(String.format(rs.getString("User_lastname"),rs.getString("User_firstname")));
                    out.println("<tr>");
                    out.print("<th>" +(count++) + "</th>");
                    out.print("<th>" +rs.getString("name")+ "</th>");
                    out.print("<th>" +rs.getString("quantity")+ "</th>");
                    out.print("<th>" +rs.getString("price")+ "</th>");
                    out.println("");
                    out.println("</tr>");
                }
                %>
                
        
        </table>
    </div>
    </body>
</html>