package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Article;
import com.briup.jz.utils.CustomerException;

public interface IArticleService {
void saveOrUpdate(Article article) throws CustomerException;
List<Article> query(String name);
void deleteById(long id) throws CustomerException;
}
