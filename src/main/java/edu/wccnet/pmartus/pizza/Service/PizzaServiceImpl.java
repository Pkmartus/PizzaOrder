package edu.wccnet.pmartus.pizza.Service;

import edu.wccnet.pmartus.pizza.dao.PizzaDao;
import edu.wccnet.pmartus.pizza.entity.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class PizzaServiceImpl implements PizzaService{

    @Autowired
    PizzaDao pizzaDAO;
    @Override
    @Transactional
    public List<Pizza> getPizzas(int orderId) {
        return pizzaDAO.getPizzas(orderId);
    }

    @Override
    @Transactional
    public void deletePizza(int orderId) {
        pizzaDAO.deletePizza(orderId);
    }

    @Override
    @Transactional
    public void savePizza(Pizza pizza) {
        pizzaDAO.savePizza(pizza);
    }
}
