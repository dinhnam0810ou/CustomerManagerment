package com.ndn.service.impl;

import java.util.List;

import com.ndn.datasource.CustomerDAO;
import com.ndn.model.Customer;
import com.ndn.service.ICustomerService;

public class CustomerService implements ICustomerService{
    
    CustomerDAO customerDAO = new CustomerDAO();
    
    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public void deleteCustomerById(int id) {
        customerDAO.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerDAO.getCustomerById(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
       customerDAO.updateCustomer(customer);
    }

    @Override
    public List<Customer> searchCustomer(String name, String gender, String phone, String membership_level) {
        return customerDAO.searchCustomer(name, gender, phone, membership_level);
    }

}
