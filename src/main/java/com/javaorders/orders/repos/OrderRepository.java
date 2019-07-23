package com.javaorders.orders.repos;

import com.javaorders.orders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders,Long> {
}
