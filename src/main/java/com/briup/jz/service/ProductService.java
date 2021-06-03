package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Product;

public interface ProductService {


	Product queryProductByid(long id);
	

	void saveOrUpdate(Product product);
	
	
	void deleteById(long id);
	
}
