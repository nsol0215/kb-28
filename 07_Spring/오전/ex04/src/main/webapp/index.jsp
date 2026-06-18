<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<form action="hello-servlet" method="post">
    한글 주소: <input type="text" name="addr" value="서울시 영등포구"><br>



</form>

</body>
</html>