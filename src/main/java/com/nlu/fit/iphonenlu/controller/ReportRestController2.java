package com.nlu.fit.iphonenlu.controller;

import java.util.List;

import com.nlu.fit.iphonenlu.dao.ReportDao;
import com.nlu.fit.iphonenlu.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController

public class ReportRestController2 {
	@Autowired
	ReportDao reportDao;
	
	@RequestMapping("/rest/report1")
	public List<Report>  getAll() {
		return reportDao.revenueByCustomer();
	}
	@RequestMapping("/rest/charcate")
	public List<Report>  charcate() {
		return reportDao.revenueByCategory();
	}
	@RequestMapping("/rest/chartrak")
	public List<Report>  chartrak() {
		return reportDao.revenueByTrak();
	}
}
