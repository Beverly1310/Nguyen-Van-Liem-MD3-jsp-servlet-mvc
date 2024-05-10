<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nliem
  Date: 09/05/2024
  Time: 9:17 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<a href="/BookServlet?action=ADD" class="btn btn-outline-primary">Them Sach</a>
<table class="table table-striped">
    <thead>
    <th>STT</th>
    <th>Name</th>
    <th>Author</th>
    <th>Category</th>
    <th>Price</th>
    <th>Stock</th>
    <th>Total Pages</th>
    <th>Year Created</th>
    <th>Status</th>
    <th colspan="2">Action</th>
    </thead>
    <c:forEach items="${bookList}" var="book" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.category.name}</td>
            <td>${book.price}</td>
            <td>${book.stock}</td>
            <td>${book.totalPages}</td>
            <td>${book.yearCreated}</td>
            <td>${book.status?"Con hang":"Het hang"}</td>
            <td><a href="/BookServlet?action=EDIT&id=${book.id}" class="btn btn-outline-warning">EDIT</a></td>
            <td><a href="/BookServlet?action=DELETE&id=${book.id}" onclick="return confirm('Ban co chac khong')" class="btn btn-outline-danger">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
