package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Article;

public interface IArticleService {
	List<Article> query(String title,String status,Long categoryId);
	
	void saveOrUpdate(Article article);
}
