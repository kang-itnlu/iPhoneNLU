package com.nlu.fit.iphonenlu.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.nlu.fit.iphonenlu.entity.Comment;
import org.springframework.web.multipart.MultipartFile;


public interface CommentService {
	 public File save(MultipartFile file, String path) throws IOException;
	 Comment Create(Comment cmt);
	 Comment Update(Comment cmt);
	 void delete(Integer id);
	 List<Comment> findbyProduct_Id(Integer product_id);
}
