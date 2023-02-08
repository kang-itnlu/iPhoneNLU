package com.nlu.fit.iphonenlu.service.impl;

import java.util.List;

import com.nlu.fit.iphonenlu.dao.TrademarkDao;
import com.nlu.fit.iphonenlu.entity.Trademark;
import com.nlu.fit.iphonenlu.service.TrademarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrademarkServiceImql implements TrademarkService {
	@Autowired
	TrademarkDao tdao;

	@Override
	public List<Trademark> findAll() {
		// TODO Auto-generated method stub
		return tdao.findAll();
	}

	@Override
	public Trademark findById(Integer trademark_id) {
		// TODO Auto-generated method stub
		return tdao.findById(trademark_id).get();
	}

	@Override
	public Trademark create(Trademark trademark_id) {
		// TODO Auto-generated method stub
		return tdao.save(trademark_id);
	}

	@Override
	public Trademark update(Trademark trademark_id) {
		// TODO Auto-generated method stub
		return tdao.save(trademark_id);
	}

	@Override
	public void delete(Integer trademark_id) {
		// TODO Auto-generated method stub
		tdao.deleteById(trademark_id);
	}
	

}
