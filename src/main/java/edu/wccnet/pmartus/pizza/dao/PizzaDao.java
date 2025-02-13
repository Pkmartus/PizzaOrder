package edu.wccnet.pmartus.pizza.dao;

import edu.wccnet.pmartus.pizza.entity.Pizza;

import java.util.List;


public interface PizzaDao {


    List<Pizza> getPizzas(int orderId);

    void savePizza(Pizza pizza);

    void deletePizza(int orderId);
}
