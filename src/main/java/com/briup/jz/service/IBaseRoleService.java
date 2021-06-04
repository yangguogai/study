package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseRole;
import com.briup.jz.utils.CustomerException;

public interface IBaseRoleService {
	// 存储或者更新一个....

	void saveOrUpdate(BaseRole baseRole) throws CustomerException;

	// 根据名字模糊查询
	List<BaseRole> query(String name);

	// 根据id删除一个
	void deleteById(Long id) throws CustomerException;

}
