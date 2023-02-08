package com.nlu.fit.iphonenlu.dao;

import java.util.List;

import com.nlu.fit.iphonenlu.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface VoteDao extends JpaRepository<Vote, Integer> {
	@Query("select v from Vote v where v.product.Product_id=?1 order by v.Vote_id desc")
	List<Vote> findbyProductId(Integer product_id);
	
}
