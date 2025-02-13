<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Pizza</title>
</head>
<body>
<%--@elvariable id="order" type="Order"--%>
<h1>${order.customer.firstName} ${order.customer.lastName}</h1>
<h2>Please customize your pizza:</h2>
<form:form action="cart" modelAttribute="order" method="POST">
    <%--@elvariable id="customerId" type="int"--%>
    <table>
        <tr>
            <%--@elvariable id="currentPizza" type=""--%>
            <td>Pick the size::</td>
            <td><form:radiobutton path="pizzas[${currentPizza}].size" label="Small" value="Small"/></td>
            <td><form:radiobutton path="pizzas[${currentPizza}].size" label="Medium" value="Medium"/></td>
            <td><form:radiobutton path="pizzas[${currentPizza}].size" label="Large" value="Large"/></td>
            <td><form:radiobutton path="pizzas[${currentPizza}].size" label="Party" value="Party"/></td>
        </tr>
        <tr>
            <td>Pick the toppings:</td>
            <td><form:checkbox path="pizzas[${currentPizza}].topping" label="Mushroom" value="Mushroom"/></td>
            <td><form:checkbox path="pizzas[${currentPizza}].topping" label="Onion" value="Onion"/></td>
            <td><form:checkbox path="pizzas[${currentPizza}].topping" label="Pepperoni" value="Pepperoni"/></td>
            <td><form:checkbox path="pizzas[${currentPizza}].topping" label="Sausage" value="Sausage"/></td>
            <td><form:checkbox path="pizzas[${currentPizza}].topping" label="Bacon" value="Bacon"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add Pizza to Cart"></td>
        </tr>
    </table>
</form:form>
</body>
</html>