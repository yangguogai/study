package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BaseUserRole;
import com.briup.jz.utils.CustomerException;

public interface IBaseUserRoleService {

	// 存储或者更新一个....
	void saveOrUpdate(BaseUserRole baseUserRole) throws CustomerException;

	// 根据id 查询
	List<BaseUserRole> query(Long id);

	// 根据id删除一个
	void deleteById(long id) throws CustomerException;

}
