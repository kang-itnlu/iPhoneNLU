package com.nlu.fit.iphonenlu.service.impl;

import java.util.List;
import java.util.Optional;

import com.nlu.fit.iphonenlu.dao.RoleDao;
import com.nlu.fit.iphonenlu.entity.Role;
import com.nlu.fit.iphonenlu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class RoleServiceImlq implements RoleService {
	@Autowired
	private RoleDao rdao;

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rdao.findAll();
	}

	

	
}
