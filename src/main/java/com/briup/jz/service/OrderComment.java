package com.briup.jz.service;

import java.util.List;

import com.briup.jz.utils.CustomerException;

public interface OrderComment {
	
	//逻辑处理层接口

		
		//保存方法
		void save(OrderComment ordercomment) throws CustomerException;
		  List<OrderComment> findAll();
		  OrderComment findById(long id);
			void saveOrUpdate(OrderComment ordercomment) throws CustomerException;
		
		List<OrderComment> query(String name);
		
		void deleteById(long id) throws CustomerException;
	
		Long getName();
		Object getId();

		

	}

