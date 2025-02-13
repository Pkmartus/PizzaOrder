<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h2>Customer List</h2>
<c:url var="sortFirst" value="/customer/list-customers">
    <c:param name="sort" value="first_name"/>
</c:url>
<c:url var="sortLast" value="/customer/list-customers">
    <c:param name="sort" value="last_name"/>
</c:url>
<table>
    <tr>
        <th><a href="${sortFirst}">First Name</a></th>
        <th><a href="${sortLast}">Last Name</a></th>
        <th>Street</th>
        <th>City</th>
        <th>State</th>
        <th>Zip Code</th>
    </tr>
    <%--@elvariable id="customers" type="Customer"--%>
    <c:forEach var="eachCustomer" items="${customers}">
        <%--suppress XmlPathReference --%>
        <c:url var="updateLink" value="/customer/updateCustomer">
            <c:param name="customerId" value="${eachCustomer.id}"/>
        </c:url>
        <c:url var="historyLink" value="/customer/orderList">
            <c:param name="customerId" value="${eachCustomer.id}"/>
        </c:url>
        <c:url var="orderLink" value="/customer/newOrder">
            <c:param name="customerId" value="${eachCustomer.id}"/>
        </c:url>
        <c:url var="deleteLink" value="/customer/deleteCustomer">
            <c:param name="customerId" value="${eachCustomer.id}"/>
        </c:url>
        <tr>
            <td>${eachCustomer.firstName}</td>
            <td>${eachCustomer.lastName}</td>
            <td>${eachCustomer.street}</td>
            <td>${eachCustomer.city}</td>
            <td>${eachCustomer.state}</td>
            <td>${eachCustomer.zip}</td>
            <td><a href="${updateLink}"><button type="button">Update Customer Info</button></a></td>
            <td><a href="${historyLink}"><button type="button">Order History</button></a></td>
            <td><a href="${orderLink}"><button type="button">Order Pizza(s)</button></a></td>
            <td><a href="${deleteLink}"><button type="button">Delete Customer</button></a></td>
        </tr>
    </c:forEach>
</table>
<form action="addCustomer" method="post">
    <input type="submit" value="Add New Customer"/>
</form>
</body>
</html>