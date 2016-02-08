package com.zinkovich.dao;
import com.zinkovich.domain.Customer;
import java.util.List;


public interface CustomerDAO {

    void saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    void updateCustomer(Customer customer);
}