package com.nlu.fit.iphonenlu.controller.user;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.nlu.fit.iphonenlu.dao.VoteDao;
import com.nlu.fit.iphonenlu.entity.Account;
import com.nlu.fit.iphonenlu.entity.Product;
import com.nlu.fit.iphonenlu.entity.Vote;
import com.nlu.fit.iphonenlu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class VoteController {
	@Autowired
	HttpServletRequest request;
	@Autowired
	VoteDao dao;
	
	@Autowired
	CommentService commservice;
	
	@RequestMapping("/vote/add")
	public String commentAdd(Model  model , @RequestParam("product_id") Integer product_id , 
			@RequestParam("content") String content , @RequestParam("vote") Integer vote , @RequestParam("image_comment") MultipartFile file) 
					throws IOException {
		String username = request.getRemoteUser();
		Vote vo = new Vote();
		Account acc = new Account();
		acc.setUsername(username);
		Product pro = new Product();
		pro.setProduct_id(product_id);
		vo.setAccount(acc);
		vo.setProduct(pro);
		vo.setVote_Content(content);
		vo.setVote(vote);
		if(file!=null) {
			File saveFile = commservice.save(file , "/static.assets/images/comments/");
			vo.setImage(file.getOriginalFilename());
		}
		dao.save(vo);
		
		return "redirect:/product/detail/"+product_id;
	}
	
	
}
