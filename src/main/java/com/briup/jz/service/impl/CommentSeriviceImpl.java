package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Comment;
import com.briup.jz.bean.CommentExample;
import com.briup.jz.dao.CommentMapper;
import com.briup.jz.service.ICommentService;
import com.briup.jz.utils.CustomerException;

@Service
public class CommentSeriviceImpl implements ICommentService{
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void saveOrUpdate(Comment comment) throws CustomerException {
		if(comment.getId()!=null) {
			commentMapper.updateByPrimaryKey(comment);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			CommentExample example = new CommentExample();
			example.createCriteria().andCommentEqualTo(comment.getComment());
			List<Comment> list = commentMapper.selectByExample(example);
			if(list.size()>0) {
				throw new CustomerException("同名的分类已存在");
			}
			commentMapper.insert(comment);
		}
	}

	@Override
	public List<Comment> query(String name) {
		CommentExample example = new CommentExample();
		if(name!=null){
			example.createCriteria().andCommentLike("%"+name+"%");
		}
		List<Comment> list = commentMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Comment comment = commentMapper.selectByPrimaryKey(id);
		if(comment == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		commentMapper.deleteByPrimaryKey(id);
		
	}

	
}
