package com.nlu.fit.iphonenlu.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.nlu.fit.iphonenlu.dao.OrderDao;
import com.nlu.fit.iphonenlu.dao.OrderDetailDao;
import com.nlu.fit.iphonenlu.entity.Order;
import com.nlu.fit.iphonenlu.entity.OrderDetail;
import com.nlu.fit.iphonenlu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderServiceImlq implements OrderService {
	@Autowired
	OrderDao dao;
	@Autowired
	OrderDetailDao ddao;
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper= new ObjectMapper();
		Order order = mapper.convertValue(orderData, Order.class);
		dao.save(order);
		TypeReference<List<OrderDetail>> type =new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details=mapper.convertValue(orderData.get("orderDetails"),type )
				.stream().peek(d ->d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		return order;
		
	}
	@Override
	public Order findById(Integer id) {
	
		return dao.findById(id).get();
	}
	
	@Override
	public List<Order> findByUsername(String username) {
		
		return dao.findByUsername(username);
	}
	
	@Override
	public List<Order> findByAllDesc() {
		return dao.findByAllDesc();
	}
	@Override
	public void deleteById(Integer id) {
		dao.deleteById(id);
		
	}
	@Override
	public Order update(Order order) {
		// TODO Auto-generated method stub
		return dao.save(order);
	}
	

	
}