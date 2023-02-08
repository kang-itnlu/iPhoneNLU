package com.nlu.fit.iphonenlu.service;

import com.nlu.fit.iphonenlu.entity.ReportCategory;
import com.nlu.fit.iphonenlu.entity.ReportProductbyDay;
import com.nlu.fit.iphonenlu.entity.ReportTrademark;

import java.util.Date;
import java.util.List;


public interface ReportService {
	
	List<ReportCategory> getReportCategory() ;
	
	List<ReportProductbyDay> getReportProductbyDaynoMinMax();
	List<ReportProductbyDay> getReportProductbyDayMinMax(Date minday , Date maxday);

	List<ReportCategory> revenueByMonth();

	List<ReportTrademark> getReportTrademark();
}
