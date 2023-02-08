package com.nlu.fit.iphonenlu.service.impl;

import java.util.List;

import com.nlu.fit.iphonenlu.dao.FavoriteDao;
import com.nlu.fit.iphonenlu.entity.Favorite;
import com.nlu.fit.iphonenlu.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	
	@Autowired
	FavoriteDao dao;
	
	@Override
	public List<Favorite> findByAllDesc() {
		return dao.findByAllDesc();
	}


	@Override
	public Favorite create(Favorite favorite) {
		return dao.save(favorite);
	}

	@Override
	public Favorite update(Favorite favorite) {
		
		return dao.save(favorite);
	}

	@Override
	public void delete(Integer favorite_id) {
		dao.deleteById(favorite_id);
	}


	@Override
	public void deleteFavoriteAdmin(Integer productid, String username) {
		dao.deleteFavaritesAdmin(productid, username);
	}


	@Override
	public List<Favorite> checkFavaoriteAdmin(Integer productid, String username) {
		return dao.checkFavaritesAdmin(productid, username);
	}


	
	
	

}
