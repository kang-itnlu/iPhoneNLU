package com.nlu.fit.iphonenlu.service;

import com.nlu.fit.iphonenlu.entity.OrderDetail;

import java.util.List;


public interface OrderDetailService {

	List<OrderDetail> findByOrderID(Integer orderid);

}
