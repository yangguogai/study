package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.OrderCommentExample;
import com.briup.jz.dao.OrderCommentMapper;
import com.briup.jz.service.OrderComment;
import com.briup.jz.utils.CustomerException;

@Service
	public class OrderCommentServiceImpl implements OrderComment {
		
		@Autowired
		private OrderCommentMapper orderCommentMapper;

		public void saveOrUpdate(OrderComment orderComment) throws CustomerException {
			if(orderComment.getId()!=null) {
				orderCommentMapper.updateByPrimaryKey(orderComment);
			} else {
				// 判断是否有同名的分类，如果有抛出异常
				OrderCommentExample example = new OrderCommentExample();
				example.createCriteria().andIdGreaterThanOrEqualTo(orderComment.getName());
				List<OrderComment> list = orderCommentMapper.selectByExample(example);
				if(list.size()>0) {
					throw new CustomerException("同名的分类已存在");
				}
				orderCommentMapper.insert(orderComment);
			}
		}

		@Override
		public List<OrderComment> query(String name) {
			OrderCommentExample example = newOrderCommentExample();
			if(name!=null){
				example.createCriteria().andStatusLike("%"+name+"%");
			}
			List<OrderComment> list = orderCommentMapper.selectByExample(example);
			return list;
		}

		private OrderCommentExample newOrderCommentExample() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteById(long id) throws CustomerException {
			OrderComment orderComment = (OrderComment) orderCommentMapper.selectByPrimaryKey(id);
			if(orderComment == null) {
				throw new CustomerException("要删除的分类信息不存在");
			}
			orderCommentMapper.deleteByPrimaryKey(id);
			
		}

		@Override
		public void save(OrderComment ordercomment) throws CustomerException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<OrderComment> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public OrderComment findById(long id) {
			// TODO Auto-generated method stub
			return null;
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

}


	