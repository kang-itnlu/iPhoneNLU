package com.nlu.fit.iphonenlu.dao;

import java.util.List;

import com.nlu.fit.iphonenlu.entity.Account;
import com.nlu.fit.iphonenlu.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AuthorityDao extends JpaRepository<Authority, Integer>{
	@Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
	List<Authority> authritiesOf(List<Account> accounts);

}
