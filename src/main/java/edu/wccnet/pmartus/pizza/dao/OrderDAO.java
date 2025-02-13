package edu.wccnet.pmartus.pizza.dao;

import edu.wccnet.pmartus.pizza.entity.PizzaOrder;

import java.util.List;

public interface OrderDAO {
    List<PizzaOrder> getOrders(int custId);

    void saveOrder(PizzaOrder order);

    void deleteOrder(int id);

    PizzaOrder getOrder(int orderId);

    List<PizzaOrder> getAllOrders();
}
