package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.BaseLog;
import com.briup.jz.bean.BaseLogExample;
import com.briup.jz.dao.BaseLogMapper;
import com.briup.jz.service.IBaseLogService;
import com.briup.jz.utils.CustomerException;

@Service
public class BaseLogServiceImpl implements IBaseLogService{
 @Autowired
 private BaseLogMapper baseLogMapper;
 @Override
 public void saveOrUpdate(BaseLog baseLog) throws CustomerException {
  if(baseLog.getId()!=null) {
   baseLogMapper.updateByPrimaryKey(baseLog);
  } else {
   // 判断是否有同名的分类，如果有抛出异常
   BaseLogExample example = new BaseLogExample();
   example.createCriteria().andRealnameEqualTo(baseLog.getRealname());
   List<BaseLog> list = baseLogMapper.selectByExample(example);
   if(list.size()>0) {
    throw new CustomerException("同名的分类已存在");
   }
   baseLogMapper.insert(baseLog);
  }
 }
 @Override
 public List<BaseLog> query(String realname) {
  // TODO Auto-generated method stub
  BaseLogExample example = new BaseLogExample();
  if(realname!=null){
   example.createCriteria().andRealnameLike("%"+realname+"%");
  }
  List<BaseLog> list = baseLogMapper.selectByExample(example);
  return list;
 }

 @Override
 public void deleteById(long id) throws CustomerException {
  BaseLog baseLog = baseLogMapper.selectByPrimaryKey(id);
  if(baseLog == null) {
   throw new CustomerException("要删除的分类信息不存在");
  }
  baseLogMapper.deleteByPrimaryKey(id);
  
 }

}
	