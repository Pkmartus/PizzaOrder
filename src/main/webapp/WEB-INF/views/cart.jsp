<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="customer" type="Customer"--%>
<html>
<head>
  <title>Cart</title>
</head>
<body>
<h2>${order.customer.firstName} ${order.customer.lastName}'s Cart:</h2>
<table>
  <%--@elvariable id="order" type="edu.wccnet.pmartus.pizza.entity.PizzaOrder"--%>
  <c:forEach var="eachPizza" items="${order.pizzas}">
    <%--suppress XmlPathReference --%>
    <c:url var="deleteLink" value="/customer/deletePizza">
      <c:param name="pizzaIndex" value="${order.pizzas.indexOf(eachPizza)}"/>
    </c:url>
      <tr>
        <td>Pizza ${order.pizzas.indexOf(eachPizza) +1}</td>
        <td>${eachPizza.size}</td>
        <td>${eachPizza.topping}</td>
        <td><a href="${deleteLink}"><button type="button">Delete Pizza</button></a></td>
      </tr>
  </c:forEach>
</table>
<c:url var="addMore" value="addPizza"/>
<a href="${addMore}"><button type="button">Add more pizza</button></a>
<c:url var="saveOrder" value="saveOrder"/>
<a href="${saveOrder}"><button type="button">PlaceOrder</button></a>
</body>
</html>

