package edu.wccnet.pmartus.pizza.controller;

import edu.wccnet.pmartus.pizza.Service.CustomerService;
import edu.wccnet.pmartus.pizza.Service.OrderService;
import edu.wccnet.pmartus.pizza.entity.Customer;
import edu.wccnet.pmartus.pizza.entity.Pizza;
import edu.wccnet.pmartus.pizza.entity.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@SessionAttributes({"order", "currentPizza"})
@RequestMapping("/customer")
public class OrderSystemController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    @GetMapping("/list-customers")
    public String listCustomers(Model model,
                                @RequestParam("sort") String sort) {
        model.addAttribute("customers",
                customerService.getCustomers(sort));
        return "list-customers";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-customer";
    }

    @PostMapping("/processCustomer")
    public String processCustomer(@ModelAttribute("customer")
                                  Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/list-customers?sort=last_name";
    }

    @RequestMapping("/updateCustomer")
    public String updateCustomer(Model model,
                                 @RequestParam("customerId") int id) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer", customer);
        return "add-customer";
    }
    @RequestMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int customerId,
                              Model model) {
        customerService.deleteCustomer(customerId);
        model.addAttribute("sort", "last_name");
        return "redirect:/customer/list-customers";
    }

    @GetMapping("/orderList")
    public String listOrders(Model model, @RequestParam("customerId") int id) {
        Customer customer = customerService.getCustomer(id);
        List<PizzaOrder> orders = orderService.getOrders(id);
        model.addAttribute("orders", orders);
        model.addAttribute("customer", customer);
        return "list-orders";
    }

    @RequestMapping("/newOrder")
    public String addOrder(Model model, @RequestParam("customerId") int id) {
        PizzaOrder order = new PizzaOrder();
        order.setCustomer(customerService.getCustomer(id));
        order.addPizza(new Pizza());
        model.addAttribute("order", order);
        model.addAttribute("currentPizza", 0);
        return "order-pizza";
    }

    @PostMapping("/cart")
    public String processPizza(@ModelAttribute("order") PizzaOrder order) {
        return "cart";
    }

    @GetMapping("/deletePizza")
    public String deletePizza(@ModelAttribute("order") PizzaOrder order,
                              @ModelAttribute("pizzaIndex") int index,
                              @ModelAttribute("currentPizza") int currentPizza,
                              SessionStatus status, Model model) {
        order.removePizza(index);
        model.addAttribute("currentPizza", currentPizza-1);
        if(order.getPizzas().isEmpty()) {
            status.setComplete();
            model.addAttribute("sort", "last_name");
            return "redirect:/customer/list-customers";
        } else
            return "cart";
    }

    @RequestMapping("/addPizza")
    public String addPizza(Model model,
                           @ModelAttribute("order") PizzaOrder order,
                           @ModelAttribute("currentPizza") int currentPizza) {
        order.addPizza(new Pizza());
        model.addAttribute("currentPizza", currentPizza+1);
        return "order-pizza";
    }

    @RequestMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("order") PizzaOrder order,
                            Model model, SessionStatus status) {
        orderService.saveOrder(order);
        status.setComplete();
        model.addAttribute("customerId", order.getCustomer().getId());
        return "redirect:/customer/orderList";
    }

    @RequestMapping("/deleteOrder")
    public String deleteOrder(@RequestParam("orderId") int orderId,
                              @RequestParam("customerId") int customerId,
                              Model model) {
        model.addAttribute("customerId", customerId);
        orderService.deleteOrder(orderId);
        return "redirect:/customer/orderList";
    }

}
