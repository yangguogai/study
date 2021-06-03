package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.ProductCategory;

public interface IProductCategoryService {
	public void saveOrUpdate(ProductCategory productcategory);
	List<ProductCategory> findAll();
	ProductCategory findById(long id);
	public void deleteById(long id);
	List<ProductCategory>findLikeName(String name);
	List<ProductCategory> query(String name);


}
