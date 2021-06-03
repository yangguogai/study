package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Category;
import com.briup.jz.utils.CustomerException;

public interface ICategoryService {
<<<<<<< HEAD
    void save(Category category) ;
	  List<Category> findAll();
	  Category findById(long id);
=======
	
	//存储或者更新一个....
>>>>>>> cb5b5e575617878e352582929adbe7aa5c25424e
	void saveOrUpdate(Category category) throws CustomerException;
	
	//根据名字模糊查询
	List<Category> query(String name);
	
	//根据id删除一个
	void deleteById(long id) throws CustomerException;
	
}
