<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h2>Sandwich Condiments</h2>

<c:forEach items="${condiment}" var="order">
  <h5>${order}</h5>
</c:forEach>
</body>
</html>