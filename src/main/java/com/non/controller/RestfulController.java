package com.non.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.non.entity.customer.CustomerEntity;
import com.non.entity.order.OrderEntity;
import com.non.repo.customer.CustomerRepo;
import com.non.repo.order.OrderRepo;

@RestController
public class RestfulController {

	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private OrderRepo repo2;
	
	@GetMapping("hello")
	public String fooBar(@RequestParam("q") String q) {

		List<CustomerEntity> a = repo.findAll();
		
		for (CustomerEntity customerEntity : a) {
			System.out.println(customerEntity.toString());
		}
		
		List<OrderEntity> b = repo2.findAll();
		
		for (OrderEntity orderEntity : b) {
			System.out.println(orderEntity.toString());
		}
		
		return "OK !!!! " + q;
	}

}
