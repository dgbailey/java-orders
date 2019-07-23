package com.javaorders.orders.repos;

import com.javaorders.orders.models.Agents;
import org.springframework.data.repository.CrudRepository;

public interface AgentRepository extends CrudRepository<Agents,Long> {
}
