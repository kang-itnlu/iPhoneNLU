package com.nlu.fit.iphonenlu.controller.admin;

import java.io.File;
import java.io.IOException;

import com.nlu.fit.iphonenlu.dao.AccountDao;
import com.nlu.fit.iphonenlu.entity.Account;
import com.nlu.fit.iphonenlu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class InfoAdminController {

	@Autowired
	AccountService accservice;
	@Autowired
	AccountDao dao;

	@RequestMapping("/admin/info")
	public String Info(Model model, @RequestParam("username") String username) {
		Account acc = accservice.findById(username);
		model.addAttribute("acc", acc);
		return "/admin/acc/info";
	}

	@RequestMapping("/admin/infonew")
	public String infonew(Model model, Account acc, @RequestParam("photo_img") MultipartFile file) throws IOException {
		model.addAttribute("acc", acc);
		if (dao.existsById(acc.getUsername())) {
			File saveFile = accservice.save(file, "static.assets/images");
			String filename = file.getOriginalFilename();
			if (filename == "") {
				accservice.update(acc);
				model.addAttribute("message", "Cập nhập thành công");
				return "/admin/acc/info";
			} else {
				acc.setPhoto(filename);
				accservice.update(acc);
				model.addAttribute("message", "Cập nhập thành công");
				return "/admin/acc/info";
			}
		}
		model.addAttribute("message", "Cập nhập  thất bại");
		return "/admin/acc/info";
	}
}
