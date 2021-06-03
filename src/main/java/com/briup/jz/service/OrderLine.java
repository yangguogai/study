package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Order;
import com.briup.jz.utils.CustomerException;

public interface OrderLine {

		void save(OrderLine orderLine) throws CustomerException;
		  List<OrderLine> findAll();
		    void findById(long id);
			void saveOrUpdate(OrderLine orderLine) throws CustomerException;
		
		List<OrderLine> query(String name);
		
		void deleteById(long id) throws CustomerException;
		Long getName();
		Object getId();
		

		

	}


