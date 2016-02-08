package com.zinkovich.service;

import com.zinkovich.domain.Customer;

import java.util.List;


public interface CustomerService {

    void saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    void updateCustomer(Customer customer);
}