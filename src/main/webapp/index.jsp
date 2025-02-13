<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="sortLast" value="customer/list-customers">
    <c:param name="sort" value="last_name"/>
</c:url>
<c:url var="allCustomers" value="customerapi/customer"/>
<c:url var="allOrders" value="orderapi/order"/>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<a href="${sortLast}">Go to Pizza Order System</a>
<br><br>
<a href="${allCustomers}">Get All Customers</a>
<br><br>
<a href="${allOrders}">Get All Orders</a>
</body>
</html>
