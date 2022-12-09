package com.ndn.service;

import java.util.List;
import com.ndn.model.Customer;



public interface ICustomerService {
    public void addCustomer(Customer customer);
    public List<Customer> getCustomers();
    public void deleteCustomerById(int id);
    public Customer getCustomerById(int id);
    public void updateCustomer(Customer customer);
    public List<Customer> searchCustomer(String name, String gender, String phone, String membership_level);
}
