package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.ProductCategory;
import com.briup.jz.bean.ProductCategoryExample;
import com.briup.jz.dao.ProductCategoryMapper;
import com.briup.jz.service.IProductCategoryService;
import com.briup.jz.utils.CustomerException;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService{
	@Autowired
	private ProductCategoryMapper productcategoryMapper;

	@Override
	public void saveOrUpdate(ProductCategory productcategory) throws CustomerException {
		if(productcategory.getId()!=null) {
			productcategoryMapper.updateByPrimaryKey(productcategory);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			ProductCategoryExample example = new ProductCategoryExample();
			example.createCriteria().andNameEqualTo(productcategory.getName());
			List<ProductCategory> list = productcategoryMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			productcategoryMapper.insert(productcategory);
		}
	}

	@Override
	public List<ProductCategory> query(String name) {
		ProductCategoryExample example = new ProductCategoryExample();
		if(name!=null){
			example.createCriteria().andNameLike("%"+name+"%");
		}
		List<ProductCategory> list = productcategoryMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		ProductCategory category = productcategoryMapper.selectByPrimaryKey(id);
		if(category == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		productcategoryMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public List<ProductCategory> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductCategory> findLikeName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

	