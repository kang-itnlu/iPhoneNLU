package com.nlu.fit.iphonenlu.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.nlu.fit.iphonenlu.entity.Post;
import org.springframework.web.multipart.MultipartFile;


public interface PostService {

	List<Post> findAll();

	Post findById(Integer id);

	List<Post> findAllStatus();

	File save(MultipartFile file, String string) throws IOException;

	Post update(Post post);

//	List<Post> findAllStatus();

}
