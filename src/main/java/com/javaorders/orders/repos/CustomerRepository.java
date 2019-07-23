package com.javaorders.orders.repos;

import com.javaorders.orders.models.Customers;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customers,Long> {
    Customers findByName(String name);
}
