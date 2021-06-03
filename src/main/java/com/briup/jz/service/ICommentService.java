package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Comment;
import com.briup.jz.utils.CustomerException;


public interface ICommentService {
	void saveOrUpdate(Comment comment) throws CustomerException;
	List<Comment> query(String name);
	void deleteById(long id) throws CustomerException;
}
