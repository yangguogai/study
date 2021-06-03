package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Article;
import com.briup.jz.bean.ArticleExample;
import com.briup.jz.dao.ArticleMapper;
import com.briup.jz.service.IArticleService;
import com.briup.jz.utils.CustomerException;
@Service
public class ArticleServiceImpl implements IArticleService{

	
	@Autowired
	private ArticleMapper articleMapper;

	public void saveOrUpdate(Article article) throws CustomerException {
		if(article.getId()!=null) {
			articleMapper.updateByPrimaryKey(article);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			ArticleExample example = new ArticleExample();
			example.createCriteria().andTitleEqualTo(article.getTitle());
			List<Article> list = articleMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			articleMapper.insert(article);
		}
	}

	public List<Article> query(String name) {
		ArticleExample example = new ArticleExample();
		if(name!=null){
			example.createCriteria().andTitleLike("%"+name+"%");
		}
		List<Article> list = articleMapper.selectByExample(example);
		return list;
	}

	public void deleteById(long id) throws CustomerException {
		Article article = articleMapper.selectByPrimaryKey(id);
		if(article == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		articleMapper.deleteByPrimaryKey(id);
	}
}
