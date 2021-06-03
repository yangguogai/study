package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseUser;

import com.briup.jz.utils.CustomerException;

public interface ICertificationApplyService {

	// 存储或者更新一个....

	void saveOrUpdate(BaseUser baseUser) throws CustomerException;

	// 根据名字模糊查询
	List<BaseUser> query(String username);

	// 根据id删除一个
	void deleteById(Long id) throws CustomerException;

}
