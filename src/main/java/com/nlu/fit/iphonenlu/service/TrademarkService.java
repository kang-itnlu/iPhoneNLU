package com.nlu.fit.iphonenlu.service;

import com.nlu.fit.iphonenlu.entity.Trademark;

import java.util.List;


public interface TrademarkService {

	List<Trademark> findAll();

	Trademark findById(Integer trademark_id);

	Trademark create(Trademark trademark_id);

	Trademark update(Trademark trademark_id);

	void delete(Integer trademark_id);

}
