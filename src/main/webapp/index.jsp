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
<a href="/BookServlet?action=LIST">Quan Ly Sach</a><br>
<a href="/CategoryServlet?action=LIST">Quan ly Danh Muc</a>
</body>
</html>