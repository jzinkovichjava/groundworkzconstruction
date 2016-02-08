package com.zinkovich.dao;

import java.util.List;

import com.zinkovich.domain.Customer;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("customerDAO")
public class CustomerDAOImpl extends AbstractDAO implements CustomerDAO{

    public void saveCustomer(Customer customer) {
        persist(customer);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> findAllCustomers() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return (List<Customer>) criteria.list();
    }

    public void updateCustomer(Customer customer){
        getSession().update(customer);
    }

}