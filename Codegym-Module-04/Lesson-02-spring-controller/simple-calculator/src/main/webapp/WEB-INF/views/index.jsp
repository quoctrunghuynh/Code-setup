<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<br>
<form action="/calculate" method="get">
    <div>
        <input type="number" name="number1">
        <input type="number" name="number2">
    </div>
    <div>
        <button type="submit" name="method" value="1">Addition(+)</button>
        <button type="submit" name="method" value="2">Subtraction(-)</button>
        <button type="submit" name="method" value="3">Multiplication(x)</button>
        <button type="submit" name="method" value="4">Division(/)</button>
    </div>
</form>

<c:if test="${not empty result}">
    <h2>Result: ${result}</h2>
</c:if>
</body>
</html>