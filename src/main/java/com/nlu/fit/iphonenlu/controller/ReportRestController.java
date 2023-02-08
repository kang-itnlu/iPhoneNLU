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

public class ReportRestController {
	@Autowired
	ReportDao reportDao;
	
	@GetMapping("/rest/report")
	public List<Report>  getAll() {
		return reportDao.revenueByMonth();
	}
	@GetMapping("/rest/reportWeek")
	public List<Report>  getAll1() {
		return reportDao.revenueByWeek();
	}
}
