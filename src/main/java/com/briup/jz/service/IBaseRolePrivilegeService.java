package com.briup.jz.service;

import java.util.List;
import com.briup.jz.bean.BaseRolePrivilege;
import com.briup.jz.utils.CustomerException;

public interface IBaseRolePrivilegeService {

	// 存储或者更新一个....
	void saveOrUpdate(BaseRolePrivilege baseRolePrivilege) throws CustomerException;

	// 根据id 查询
	List<BaseRolePrivilege> query(Long id);

	// 根据id删除一个
	void deleteById(long id) throws CustomerException;
}
