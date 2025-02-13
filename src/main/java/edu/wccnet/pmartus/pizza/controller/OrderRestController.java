package edu.wccnet.pmartus.pizza.controller;


import edu.wccnet.pmartus.pizza.Service.OrderService;
import edu.wccnet.pmartus.pizza.entity.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderapi")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public List<PizzaOrder> getAllOrders() {
        return orderService.getAllOrders();
    }
    @GetMapping("/order/{orderId}")
    public PizzaOrder getOrder(@PathVariable int orderId) {
        return orderService.getOrder(orderId);
    }

    @PostMapping("/order")
    public PizzaOrder addOrder(@RequestBody PizzaOrder order) {
        //order.setId(0);
        orderService.saveOrder(order);
        return order;
    }

    @PutMapping("/order")
    public PizzaOrder updateOrder(@RequestBody PizzaOrder order) {
        orderService.saveOrder(order);
        return order;
    }
    @DeleteMapping("/order/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }
}
