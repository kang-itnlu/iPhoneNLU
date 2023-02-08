package com.nlu.fit.iphonenlu.controller.user;
import java.util.List;

import com.nlu.fit.iphonenlu.dao.AccountDao;
import com.nlu.fit.iphonenlu.dao.ProductDao;
import com.nlu.fit.iphonenlu.entity.Product;
import com.nlu.fit.iphonenlu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	@Autowired
	ProductDao pdao;
	@Autowired
	AccountService accservice;
	
	@Autowired
	AccountDao dao;
	@RequestMapping("/home/index")
	public String home(Model model) {
		List<Product> list = pdao.findByAllDis();
		model.addAttribute("item1", list);
		List<Product> list1 = pdao.findByAllSpe();
		model.addAttribute("item2", list1);
		List<Product> list2 = pdao.getTop10();
		model.addAttribute("item3", list2);
	
		return "user/home/index";
	}

}
