package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Order;
import com.briup.jz.bean.OrderExample;
import com.briup.jz.dao.OrderMapper;
import com.briup.jz.service.OrderService;
import com.briup.jz.utils.CustomerException;



@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;

	public void saveOrUpdate(Order order) throws CustomerException {
		if(order.getId()!=null) {
			orderMapper.updateByPrimaryKey(order);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			OrderExample example = new OrderExample();
			example.createCriteria().andIdGreaterThanOrEqualTo(order.getName());
			List<Order> list = orderMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			orderMapper.insert(order);
		}
	}

	@Override
	public List<Order> query(String name) {
		OrderExample example = newOrderExample();
		if(name!=null){
			example.createCriteria().andNameLike("%"+name+"%");
		}
		List<Order> list = orderMapper.selectByExample(example);
		return list;
	}

	private OrderExample newOrderExample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Order order = orderMapper.selectByPrimaryKey(id);
		if(order == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		orderMapper.deleteByPrimaryKey(id);
		
	}

	
	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void save(Order order) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
		
	}


