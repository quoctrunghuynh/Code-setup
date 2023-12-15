<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<div style="text-align: center">
    <h1>Ứng dụng chuyển đổi tiền tệ</h1>
    <form action="${pageContext.request.contextPath}/convert" method="post">
        <label>Exchange Rate:
            <input type="number" name="exchangeRate" step="0.01" required>
        </label><br>

        <label>Usd amount:
            <input type="number" name="usdAmount" step="0.01" required>
        </label><br>
        <button type="submit">Convert</button>

    </form>
    <p>Giá sau quy đổi: ${vndAmount}</p>
</div>
</body>
</html>