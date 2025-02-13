<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="customer" type="Customer"--%>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h2>Orders for ${customer.firstName} ${customer.lastName}</h2>
<table>
    <tr>
        <th>Order ID</th>
    </tr>
    <%--@elvariable id="orders" type="java.util.List"--%>
    <c:forEach var="eachOrder" items="${orders}">
        <%--suppress XmlPathReference --%>
        <c:url var="deleteLink" value="/customer/deleteOrder">
            <c:param name="orderId" value="${eachOrder.id}"/>
            <c:param name="customerId" value="${customer.id}"/>
        </c:url>
        <tr>
            <td>${eachOrder.id}</td>
            <th>Size</th>
            <th>toppings</th>
            <td><a href="${deleteLink}"><button type="button">Delete Order</button></a></td>
        </tr>
            <c:forEach var="eachPizza" items="${eachOrder.pizzas}">
                <tr>
                    <td></td>
                    <td>${eachPizza.size}</td>
                    <td>${eachPizza.topping}</td>
                </tr>
            </c:forEach>
    </c:forEach>
</table>
<c:url var="sortLast" value="list-customers">
    <c:param name="sort" value="last_name"/>
</c:url>
<a href="${sortLast}"><button type="button">Back to Customer List</button></a>
<c:url var="newOrder" value="newOrder">
    <c:param name="customerId" value="${customer.id}"/>
</c:url>
<a href="${newOrder}"><button type="button">Place another order</button></a>
</body>
</html>
