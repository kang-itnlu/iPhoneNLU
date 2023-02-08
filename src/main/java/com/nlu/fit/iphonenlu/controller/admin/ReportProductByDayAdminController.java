package com.nlu.fit.iphonenlu.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.nlu.fit.iphonenlu.dao.ReportProductbyDayDao;
import com.nlu.fit.iphonenlu.entity.ReportProductbyDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportProductByDayAdminController {
	private static final Random RANDOM = new Random(System.currentTimeMillis());
	
	@Autowired
	ReportProductbyDayDao DAO;
	
	@RequestMapping("/admin/report" )
    public String getPieChart(Model model ,@RequestParam(value= "minday" , required = false)@DateTimeFormat(pattern="yyyy-MM-dd") Date minday,
    		@RequestParam(value = "maxday", required = false)@DateTimeFormat(pattern="yyyy-MM-dd") Date maxday) {
    	  try {
    		  Map<String, Double > graphData = new TreeMap<>();
    	    	if(minday==(null)  && maxday==(null)) {
    	    		List<ReportProductbyDay>  report =  DAO.reportProdctByDaynoMinMax();
    	    		model.addAttribute("listreprt", report);
    	            for(int i=0 ; i<report.size();i++) {
    	            	graphData.put(report.get(i).getName().toString(),report.get(i).getSum());
    	            }
    	    	}
    	    	else {
    	    	List<ReportProductbyDay>  report =  DAO.reportProdctByDay(minday,maxday);
    	    	model.addAttribute("listreprt", report);
    	        for(int i=0 ; i<report.size();i++) {
    	        	graphData.put(report.get(i).getName().toString(),report.get(i).getSum());
    	        }
    	    	}
    	    	
    	        model.addAttribute("chartData", graphData);
    	        model.addAttribute("message", "Thống kê thành công");
    	        return "admin/report/char2";
			
		} catch (Exception e) {
			model.addAttribute("message", "Không được để trống Minday hoặc Maxday");
			return "admin/report/char2";
		} 
    	  
    }
	
	
  
   
}
