package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.OrderLineExample;
import com.briup.jz.dao.OrderLineMapper;
import com.briup.jz.service.OrderLine;
import com.briup.jz.utils.CustomerException;

@Service
public class OrderLineServiceImpl implements OrderLine {
	
	@Autowired
	private OrderLineMapper orderLineMapper;

	public void saveOrUpdate(OrderLine orderLine) throws CustomerException {
		if(orderLine.getId()!=null) {
			orderLineMapper.updateByPrimaryKey(orderLine);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			OrderLineExample example = new OrderLineExample();
			example.createCriteria().andIdGreaterThanOrEqualTo(orderLine.getName());
			List<OrderLine> list = orderLineMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			orderLineMapper.insert(orderLine);
		}
	}

	public List<OrderLine> query1(String name) {
		OrderLineExample example = newOrderLineExample();
		if(name!=null){
			example.createCriteria().andStatusLike("%"+name+"%");
		}
		List<OrderLine> list = orderLineMapper.selectByExample(example);
		return list;
	}

	private OrderLineExample newOrderLineExample() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override

	public void deleteById(long id) throws CustomerException {
		OrderLine orderLine = (OrderLine) orderLineMapper.selectByPrimaryKey(id);
		if(orderLine == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		orderLineMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void save(OrderLine orderLine) throws CustomerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderLine> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void findById(long id) {
		// TODO Auto-generated method stub
		return;
	}


	@Override
	public Long getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderLine> query(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	}


	

	



	









