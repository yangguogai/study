package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.BasePrivilege;
import com.briup.jz.utils.CustomerException;

public interface IBasePrivilegeService {
	// 存储或者更新一个....
	void saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException;

	// 根据名字模糊查询
	List<BasePrivilege> query(String name);

	// 根据id删除一个
	void deleteById(long id) throws CustomerException;

}
