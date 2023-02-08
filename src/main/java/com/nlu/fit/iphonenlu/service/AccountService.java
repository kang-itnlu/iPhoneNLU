package com.nlu.fit.iphonenlu.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.nlu.fit.iphonenlu.entity.Account;
import org.springframework.web.multipart.MultipartFile;




public interface AccountService {
	 Account findById(String username);

	 List<Account> getAdminnostrators();

	 List<Account> findAll();
	 
	 Account create(Account account);
	 
	 Account update(Account account);
	 
	 void delete(String username);
	 
	 public File save(MultipartFile file, String path)  throws IOException;
}
