package com.nlu.fit.iphonenlu.service.impl;

import java.util.Date;
import java.util.List;

import com.nlu.fit.iphonenlu.dao.ProductDao;
import com.nlu.fit.iphonenlu.dao.ReportProductbyDayDao;
import com.nlu.fit.iphonenlu.entity.ReportCategory;
import com.nlu.fit.iphonenlu.entity.ReportProductbyDay;
import com.nlu.fit.iphonenlu.entity.ReportTrademark;
import com.nlu.fit.iphonenlu.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReportServiceImql implements ReportService {
	
	@Autowired
	ReportService reportdao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ReportProductbyDayDao reportproductbydaydao;
	
	@Override
	public List<ReportCategory> getReportCategory() {
		return productDao.getReportCategory();
	}

	@Override
	public List<ReportProductbyDay> getReportProductbyDaynoMinMax() {
		// TODO Auto-generated method stub
		return reportproductbydaydao.reportProdctByDaynoMinMax();
	}

	@Override
	public List<ReportProductbyDay> getReportProductbyDayMinMax(Date minday, Date Max) {
		// TODO Auto-generated method stub
		return reportproductbydaydao.reportProdctByDay( minday,  Max);
	}

	@Override
	public List<ReportCategory> revenueByMonth() {
		// TODO Auto-generated method stub
		return reportdao.revenueByMonth();
	}

	@Override
	public List<ReportTrademark> getReportTrademark() {
		// TODO Auto-generated method stub
		return productDao.getReportTrademark();
	}

}
