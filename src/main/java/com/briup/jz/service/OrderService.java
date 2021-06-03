package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Order;
import com.briup.jz.utils.CustomerException;

//逻辑处理层接口
public interface  OrderService{
	
	//保存方法
	void save(Order order) throws CustomerException;
	  List<Order> findAll();
	  Order findById(long id);
		void saveOrUpdate(Order order) throws CustomerException;
	
	List<Order> query(String name);
	
	void deleteById(long id) throws CustomerException;

	

}