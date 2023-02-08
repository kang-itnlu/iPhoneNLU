package com.nlu.fit.iphonenlu.service;

import com.nlu.fit.iphonenlu.entity.Category;

import java.util.List;


public interface CategoryService {

	List<Category> findAll();

	Category findById(Integer category_id);

	Category create(Category category);

	Category update(Category category);

	void delete(Integer category_id);

}
