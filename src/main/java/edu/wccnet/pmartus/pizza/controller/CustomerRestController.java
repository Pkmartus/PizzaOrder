package edu.wccnet.pmartus.pizza.controller;

import edu.wccnet.pmartus.pizza.Service.CustomerService;
import edu.wccnet.pmartus.pizza.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerapi")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }
    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/customer")
    public void addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerService.saveCustomer(customer);
    }

    @PutMapping("/customer")
    public Customer updateStudent(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }
    @DeleteMapping("/customer/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
