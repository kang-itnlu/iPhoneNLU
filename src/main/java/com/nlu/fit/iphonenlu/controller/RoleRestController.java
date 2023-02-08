package com.nlu.fit.iphonenlu.controller;

import java.util.List;

import com.nlu.fit.iphonenlu.entity.Role;
import com.nlu.fit.iphonenlu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
	@Autowired
	RoleService roleService;
	@GetMapping
	public List<Role> getAll(){
		return roleService.findAll();
	}
}
