package com.nlu.fit.iphonenlu.controller;

import java.util.List;

import com.nlu.fit.iphonenlu.dao.OrderDao;
import com.nlu.fit.iphonenlu.dao.ReportProductbyDayDao;
import com.nlu.fit.iphonenlu.entity.Order;
import com.nlu.fit.iphonenlu.entity.ReportProductbyDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
public class HomeRestController {
	
	@Autowired
	OrderDao odao;
	@Autowired
	ReportProductbyDayDao pReportProductbyDayDao;
	
	
	
	
	@GetMapping("/rest/ordertop10")
	public List<Order> getAll(){
		return odao.getTop10();
	}
	@GetMapping("/rest/producttop10")
	public List<ReportProductbyDay> getStatus(){
		return  pReportProductbyDayDao.reportProdctTop10();
	}
}
