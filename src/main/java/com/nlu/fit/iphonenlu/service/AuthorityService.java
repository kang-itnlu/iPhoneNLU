package com.nlu.fit.iphonenlu.service;

import com.nlu.fit.iphonenlu.entity.Authority;

import java.util.List;


public interface AuthorityService {

	List<Authority> findAuthoritiesOfAdministrators();

	List<Authority> findAll();

	Authority create(Authority auth);

	void delete(Integer id);

}
