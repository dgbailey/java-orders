package com.javaorders.orders.service;

import com.javaorders.orders.models.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> findAll();
    //list all customers


    Customers findCustomerByName(String name);


    void delete(long custcode);

    Customers save(Customers restaurant);
    //add customer

    Customers update(Customers restaurant, long custcode);

}
