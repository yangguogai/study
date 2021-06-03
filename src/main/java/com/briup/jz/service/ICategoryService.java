package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Category;
import com.briup.jz.utils.CustomerException;

public interface ICategoryService {
    void save(Category category) ;
	  List<Category> findAll();
	  Category findById(long id);
	void saveOrUpdate(Category category) throws CustomerException;
	
	List<Category> query(String name);
	
	void deleteById(long id) throws CustomerException;
	
}
