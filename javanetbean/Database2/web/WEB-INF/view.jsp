<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@page import="web.module.connect.KetNoi" %>
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
                <caption><h2>List of Student</h2></caption>
                <tr>
                    <th>StudentID</th>
                    <th>FirstName</th>

                    <th>LastName</th>
                    <th>Address</th>
                    <th>Telephone</th>
                    <th>Email</th>
                    <th>Password</th>
                </tr>
                <%
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ClassManagement;user=duc;password=duc123456");
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("select * from Student");
                //int count = 1;
                while (rs.next()) {
                    out.println("<tr>");
                    
                    out.print("<th>" +rs.getString("StudentID")+ "</th>");
                    out.print("<th>" +rs.getString("FirstName")+ "</th>");
                    out.print("<th>" +rs.getString("LastName")+ "</th>");
                    out.print("<th>" +rs.getString("Address")+ "</th>");
                    out.print("<th>" +rs.getString("Telephone")+ "</th>");
                    out.print("<th>" +rs.getString("Email")+ "</th>");
                    out.print("<th>" +rs.getString("Password")+ "</th>");
                    out.println("");
                    out.println("</tr>");
                }
                %>


            </table>
        </div>
    </body>
</html>