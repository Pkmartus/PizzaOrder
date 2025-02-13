package edu.wccnet.pmartus.pizza.dao;

import edu.wccnet.pmartus.pizza.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers(String sort);

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int customerId);
}
