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
<form action="/BookServlet?action=EDIT" method="post">
    <label>ID</label>
    <input type="text" name="id" readonly value="${book.id}"><br>
    <label>Name</label>
    <input type="text" name="name" value="${book.name}"><br>
    <label>Author</label>
    <input type="text" name="author" value="${book.author}"><br>
    <label>Category</label>
    <select name="category" >
        <c:forEach items="${categoryList}" var="category" varStatus="loop">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select><br>
    <label>Price</label>
    <input type="text" name="price" value="${book.price}"><br>
    <label>Stock</label>
    <input type="text" name="stock" value="${book.stock}"><br>
    <label>Total Pages</label>
    <input type="text" name="totalPages" value="${book.totalPages}"><br>
    <label>Year created</label>
    <input type="text" name="yearCreated" value="${book.yearCreated}"><br>
    <label>Status</label>
    <input type="radio" name="status" value="true" ${book.status?"checked":""}><span>Hien</span>
    <input type="radio" name="status" value="false" ${!book.status?"checked":""}><span>An</span><br>
    <input type="submit" name="action" value="EDIT">
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
