package com.nlu.fit.iphonenlu.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.nlu.fit.iphonenlu.dao.AccountDao;
import com.nlu.fit.iphonenlu.entity.Account;
import com.nlu.fit.iphonenlu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class AccountServiceImql implements AccountService {
	

	@Autowired
	AccountDao adao;
	@Autowired
	HttpServletRequest request;
	
	@Override
	public Account findById(String username) {
		return adao.findById(username).get();
	}

	@Override
	public List<Account> getAdminnostrators() {
		return adao.getAdministrators();
	}

	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Override
	public Account create(Account account) {
		return adao.save(account);
	}

	@Override
	public Account update(Account account) {
		return adao.save(account);
	}

	@Override
	public void delete(String username) {
		adao.deleteById(username);
		
	}

	@Override
	public File save(MultipartFile file, String path) throws IOException {
		if(!file.isEmpty()) {
			String path1 = "E:/4th Year second semester/Github/iPhoneNLU/src/main/resources/";
			File directory = new File(path1 + path);
			if (!directory.exists()) {
				directory.mkdirs();
			}
			String fileName = file.getOriginalFilename();
			File f = new File(directory , fileName);
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(f));
			byte[] data = file.getBytes();
			bufferedOutputStream.write(data);
			bufferedOutputStream.close();
			
			File dir = new File(request.getServletContext().getRealPath(path));
			if(!dir.exists()) {
				dir.mkdirs();
			}
			try {
				File savedFile = new File(dir, file.getOriginalFilename());
				file.transferTo(savedFile);
				return savedFile;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	
}
