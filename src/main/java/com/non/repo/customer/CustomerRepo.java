package com.non.repo.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.non.entity.customer.CustomerEntity;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {

}
