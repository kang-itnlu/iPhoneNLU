package com.nlu.fit.iphonenlu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nlu.fit.iphonenlu.service.CategoryService;
import com.nlu.fit.iphonenlu.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



@Component
public class Globallnterceptor implements HandlerInterceptor {
	@Autowired
	CategoryService categoryService;
	@Autowired
	TrademarkService trademarkService;
	// khai báo toàn chương trình hiển thị loại sản phẩm và thương hiệu
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("cates", categoryService.findAll());
		request.setAttribute("trads", trademarkService.findAll());
	}

	
}
