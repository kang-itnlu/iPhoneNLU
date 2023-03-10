package com.nlu.fit.iphonenlu.controller;

import java.util.List;
import java.util.Optional;

import com.nlu.fit.iphonenlu.entity.Account;
import com.nlu.fit.iphonenlu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountService accountService;
	
	@GetMapping
	public List<Account> getAccounts(@RequestParam("admin")Optional<Boolean>admin){
		if (admin.orElse(false)) {
			return accountService.getAdminnostrators();
			
		}
		return accountService.findAll();
	}
}
