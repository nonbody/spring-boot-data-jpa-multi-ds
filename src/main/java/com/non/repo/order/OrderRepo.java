package com.non.repo.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.non.entity.order.OrderEntity;

public interface OrderRepo extends JpaRepository<OrderEntity, Integer> {

}
