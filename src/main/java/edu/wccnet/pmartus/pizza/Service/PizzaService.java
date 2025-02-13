package edu.wccnet.pmartus.pizza.Service;

import edu.wccnet.pmartus.pizza.entity.Pizza;

import java.util.List;

public interface PizzaService {

    List<Pizza> getPizzas(int orderId);

    void savePizza(Pizza pizza);

    void deletePizza(int orderId);
}
