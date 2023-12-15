<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nhat
  Date: 5/20/18
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create employee</title>
</head>
<body>
<div id="global">
    <form:form commandName="employee" action="save-employee" method="post">
        <fieldset>
            <legend>Add an employee</legend>
            <p>
                <label for="firstName">First Name: </label>
                <form:input path="firstName" tabindex="1"/>
            </p>
            <p>
                <label for="lastName">Last Name: </label>
                <form:input path="lastName" tabindex="2"/>
            </p>
            <p>
                <form:errors path="birthDate" cssClass="error"/>
            </p>
            <p>
                <label for="birthDate">Date Of Birth: </label>
                <form:input path="birthDate" tabindex="3" />
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5" value="Add Employee">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>