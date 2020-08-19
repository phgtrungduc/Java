<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;
              charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
         <h1>Vui lòng đăng nhập để xem ảnh này</h1>
        <form action="LoginServlet" method="post" >
            Name:<input type="text" name="name" required><br>
            Password:<input type="password" name="password" required><br>
            <input type="submit" value="login">
        </form>
    </body>
</html>