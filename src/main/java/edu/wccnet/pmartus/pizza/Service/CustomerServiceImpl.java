package edu.wccnet.pmartus.pizza.Service;

import edu.wccnet.pmartus.pizza.dao.CustomerDAO;
import edu.wccnet.pmartus.pizza.entity.Customer;
import edu.wccnet.pmartus.pizza.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerDAO customerDAO;
    @Override
    @Transactional
    public List<Customer> getCustomers(String sort) {
        return customerDAO.getCustomers(sort);
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return getCustomers("last_name");
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        isNull(id);
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        isNull(customerId);
        customerDAO.deleteCustomer(customerId);
    }
    public void isNull(int id) {
        Customer customer = customerDAO.getCustomer(id);
        if (customer == null)
            throw new NotFoundException("Customer id not found. Id: " + id);
    }
}
