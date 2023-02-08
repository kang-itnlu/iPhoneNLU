package com.nlu.fit.iphonenlu.controller.admin;

import com.nlu.fit.iphonenlu.dao.TrademarkDao;
import com.nlu.fit.iphonenlu.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrademarkAdminController {
	@Autowired
	TrademarkService trademarkService;
	@Autowired
	TrademarkDao tdao;
	
//	@RequestMapping("trademark/list")
//	public String home(Model model) {
//		List<Trademark> list = trademarkService.findAll();
//		model.addAttribute("items", list);
//		return "admin/trademark/list";
//	}
//	@RequestMapping("/trademark/edit")
//	public String edit(Model model , @RequestParam("trademark_id") Integer trademark_id) {
//		Trademark tra = tdao.findById(trademark_id).get();
//		model.addAttribute("tra",tra);
//		return "admin/trademark/edit";
//	}
//	@RequestMapping("/trademark/delete/{trademark_id}")
//	public String delete(@PathVariable("trademark_id") Integer trademark_id) {
//		trademarkService.delete(trademark_id);
//		return "redirect:/trademark/list";
//	}
	@RequestMapping("/admin/trademark/list")
	public String home(Model model) {
	
		return "admin/trademark/index";
	}
}
