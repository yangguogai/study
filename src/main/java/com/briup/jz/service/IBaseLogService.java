package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseLog;
import com.briup.jz.utils.CustomerException;

public interface IBaseLogService {
void saveOrUpdate(BaseLog baseLog) throws CustomerException;
 
 List<BaseLog> query(String realname);
 
 void deleteById(long id) throws CustomerException;
}