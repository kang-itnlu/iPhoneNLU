package com.nlu.fit.iphonenlu.controller.admin;

import com.nlu.fit.iphonenlu.dao.CategoryDao;
import com.nlu.fit.iphonenlu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryAdminController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	CategoryDao cdao;
	
//	@RequestMapping("category/list")
//	public String home(Model model) {
//		List<Category> list = categoryService.findAll();
//		model.addAttribute("items", list);
//		return "admin/category/list";
//	}
//	@RequestMapping("/category/edit")
//	public String edit(Model model , @RequestParam("category_id") Integer category_id) {
//		Category cat = cdao.findById(category_id).get();
//		model.addAttribute("cat",cat);
//		return "admin/category/edit";
//	}
//	@RequestMapping("/category/delete/{category_id}")
//	public String delete(@PathVariable("category_id") Integer category_id) {
//		categoryService.delete(category_id);
//		return "redirect:/category/list";
//	}
	@RequestMapping("/admin/category/list")
	public String home(Model model) {
		
		return "admin/category/index";
	}
	
}
