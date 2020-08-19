<%-- 
    Document   : them
    Created on : Oct 7, 2019, 9:47:39 AM
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
        <form action="Control" method="get">
            Nhập ID sản phẩm: <br>
            <input type="text" name="category_id">
            <br>
            Nhập tên sản phẩm: <br>
            <input type="text" name="name">
            <br>
            Nhập giá sản phẩm:<br>
            <input type="text" name="price" >
            <br>
            Nhập đơn vị: <br>
            <input type="text" name="unit" >
            <br>
            Thêm đường dẫn đến ảnh sản phẩm: <br>
            <input type="text" name="photo_path" >
            <br>
            <input type="submit" value="Thêm" >
        </form>
    </body>
</html>
