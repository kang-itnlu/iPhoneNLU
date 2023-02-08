package com.nlu.fit.iphonenlu.controller;

import java.util.List;

import com.nlu.fit.iphonenlu.entity.OrderDetail;
import com.nlu.fit.iphonenlu.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orderdetails")
public class OrderDetailRestController {
	@Autowired
	OrderDetailService orderService;
	
	@GetMapping("{id}")
	public List<OrderDetail> getAll(@PathVariable("id") Integer id){
		return orderService.findByOrderID(id);
	}
}