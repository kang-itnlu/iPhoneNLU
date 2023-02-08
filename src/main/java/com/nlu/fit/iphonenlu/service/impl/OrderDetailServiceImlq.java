package com.nlu.fit.iphonenlu.service.impl;

import java.util.List;
import java.util.Optional;

import com.nlu.fit.iphonenlu.dao.OrderDetailDao;
import com.nlu.fit.iphonenlu.entity.OrderDetail;
import com.nlu.fit.iphonenlu.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;





@Service
public class OrderDetailServiceImlq implements OrderDetailService {
	@Autowired
	OrderDetailDao dao;

	@Override
	public List<OrderDetail> findByOrderID(Integer orderid) {
		return dao.findByOrderID(orderid);
	}

	

	

	
}
