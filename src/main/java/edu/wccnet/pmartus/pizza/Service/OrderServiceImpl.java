package edu.wccnet.pmartus.pizza.Service;

import edu.wccnet.pmartus.pizza.dao.OrderDAO;
import edu.wccnet.pmartus.pizza.dao.PizzaDao;
import edu.wccnet.pmartus.pizza.entity.PizzaOrder;
import edu.wccnet.pmartus.pizza.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO orderDAO;
    @Override
    @Transactional
    public void saveOrder(PizzaOrder order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public void deleteOrder(int id) {
        isNull(id);
        orderDAO.deleteOrder(id);
    }

    @Override
    @Transactional
    public PizzaOrder getOrder(int orderId) {
        isNull(orderId);
        return orderDAO.getOrder(orderId);
    }

    @Override
    @Transactional
    public List<PizzaOrder> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Override
    @Transactional
    public List<PizzaOrder> getOrders(int custId) {
        return orderDAO.getOrders(custId);
    }
    public void isNull(int id) {
        PizzaOrder order = orderDAO.getOrder(id);
        if (order == null)
            throw new NotFoundException("Order id not found. Id: " + id);
    }
}
