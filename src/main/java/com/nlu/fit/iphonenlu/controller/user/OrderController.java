package com.nlu.fit.iphonenlu.controller.user;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.nlu.fit.iphonenlu.dao.OrderDao;
import com.nlu.fit.iphonenlu.dao.OrderDetailDao;
import com.nlu.fit.iphonenlu.entity.Order;
import com.nlu.fit.iphonenlu.service.OrderDetailService;
import com.nlu.fit.iphonenlu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	OrderDao odao;
	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	OrderDetailDao orderDetailDao;
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "user/order/checkout";
	}
	@RequestMapping("/order/list")
	public String list(Model model , HttpServletRequest request, @RequestParam("page") Optional<Integer> page) {
		
		String username= request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "user/order/list";
	}
	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Integer id , Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "user/order/detail";
	}
	
	@RequestMapping("/order/remove")
	public String remove(@RequestParam("order_id") Integer id) {
//		int id_order = Integer.parseInt(id);
		Order order = odao.getById(id);
		order.setStatus(4);
		odao.save(order);
		return "redirect:/order/list";
	}
	@RequestMapping("/send")
	public String sendMail(@RequestParam("to") String to, @RequestParam("subject") String subject, @RequestParam("content") String content,
			@ModelAttribute("order") Order order) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setText(
				"T??n ng?????i ?????t h??ng : " 
		+ content 
		+ "\n"
		+ "phuong thuc thanh toan :  "
		+ order.getMethod() 
		+ "\n"
				+ "S?? ??i???n tho???i ng?????i ?????t h??ng : "
		+ order.getPhone()
		+ "\n"
		+ "Don hang co gia tri :"
				+ order.getPrice() 
				+ "\n" 
				+ "Lo???i ti???n t??? : " 
				+ order.getCurrency() 
				+ "\n"
				+ "Intent : "
				+ order.getIntent() 
				+ "\n" 
				+ "Description : " 
				+ order.getStatus()
				+ "\n" 
				+ "Ngay t???o ????n : "
				+ order.getCreateDate() 
				+ "\n" 
				+ "?????a ch??? nh???n h??ng : " 
				+ order.getAddress() 
				+ "\n" 
		+ "\n" 
		+ "================================");

		msg.setSubject("????n h??ng s??? : " + subject);
		javaMailSender.send(msg);
		return "user/result";
	}

	
}