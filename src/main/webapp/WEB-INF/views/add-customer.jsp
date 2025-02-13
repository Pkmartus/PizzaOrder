<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Customer</title>
</head>
<body>
<b>Please Enter Customer Info:</b>
<%--@elvariable id="customer" type="Customer"--%>
<form:form action="processCustomer" modelAttribute="customer" method="POST">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td>First Name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Street:</td>
            <td><form:input path="street"/></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><form:select path="state">
                <form:option value="MI" label="MI"/>
                <form:option value="IN" label="IN"/>
                <form:option value="WA" label="WA"/>
                <form:option value="CA" label="CA"/>
                <form:option value="FL" label="FL"/>
            </form:select></td>
        </tr>
        <tr>
            <td>Zip:</td>
            <td><form:input path="Zip"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save Customer"/></td>
        </tr>
    </table>
    <c:url var="sortLast" value="list-customers">
        <c:param name="sort" value="last_name"/>
    </c:url>
    <a href="${sortLast}"><button type="button">Back to Customer List</button></a>
</form:form>
</body>
</html>
