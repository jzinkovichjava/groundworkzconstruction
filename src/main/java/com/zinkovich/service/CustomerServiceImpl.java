package com.zinkovich.service;

import com.zinkovich.dao.CustomerDAO;
import com.zinkovich.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDAO dao;

    public void saveCustomer(Customer customer) {
        dao.saveCustomer(customer);
    }

    public List<Customer> findAllCustomers() {
        return dao.findAllCustomers();
    }

    public void updateCustomer(Customer customer){
        dao.updateCustomer(customer);
    }
}