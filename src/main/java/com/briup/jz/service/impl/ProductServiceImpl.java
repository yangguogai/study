package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Product;
import com.briup.jz.dao.ProductMapper;
import com.briup.jz.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	// 根据id查询银行账户充值提现信息
	@Override
	public Product queryProductByid(long id) {

		return productMapper.selectByPrimaryKey(id);
	}

	// 存取或者修改
	@Override
	public void saveOrUpdate(Product product) {

		if (product.getId() != null) {
			productMapper.updateByPrimaryKey(product);
		} else {
			productMapper.insert(product);
		}

	}

	// 删除一个id信息
	@Override
	public void deleteById(long id) {

		productMapper.deleteByPrimaryKey(id);

	}

}
