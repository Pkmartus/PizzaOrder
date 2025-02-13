package edu.wccnet.pmartus.pizza.Service;

import edu.wccnet.pmartus.pizza.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers(String sort);

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int customerId);
}
