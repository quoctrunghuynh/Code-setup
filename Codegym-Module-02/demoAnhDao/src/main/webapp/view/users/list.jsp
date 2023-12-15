<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User list</title>
</head>
<body>
<h2>List of user</h2>
<div style="padding-top: 5px;">
    <a href="<c:url value="/user/add"/>">Add New</a>
</div>
<table id="dataTable" width="100%" border="1px solid black">
    <thead>
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Email</th>
        <th>Phone</th>
        <th>#</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
            <td>
                <a href="<c:url value="/user/detail"/>?id=${user.id}">Detail</a>
                <a href="<c:url value="/user/edit"/>?id=${user.id}">Edit</a>
                <a href="<c:url value="/user/remove"/>?id=${user.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>