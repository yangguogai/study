package com.briup.jz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.jz.bean.BasePrivilege;
import com.briup.jz.bean.BasePrivilegeExample;
import com.briup.jz.dao.BasePrivilegeMapper;
import com.briup.jz.service.IBasePrivilegeService;
import com.briup.jz.utils.CustomerException;

@Service
public class BasePrivilegeServiceImpl implements IBasePrivilegeService {

	@Autowired
	private BasePrivilegeMapper basePrivilegeMapper;

	// 保存或者更新操作
	@Override
	public void saveOrUpdate(BasePrivilege basePrivilege) throws CustomerException {

		if (basePrivilege.getId() != null) {

			basePrivilegeMapper.updateByPrimaryKey(basePrivilege);

		} else {
			// 判断是否有同名的分类，如果有抛出异常

			BasePrivilegeExample example = new BasePrivilegeExample();

			example.createCriteria().andNameEqualTo(basePrivilege.getName());

			List<BasePrivilege> list = basePrivilegeMapper.selectByExample(example);

			if (list.size() > 0) {
				throw new CustomerException("同名的分类已存在");

			}
			basePrivilegeMapper.insert(basePrivilege);
		}

	}

	// 根据名字模糊查询
	@Override
	public List<BasePrivilege> query(String name) {

		BasePrivilegeExample example = new BasePrivilegeExample();

		if (name != null) {

			example.createCriteria().andNameLike("%" + name + "%");

		}
		List<BasePrivilege> list = basePrivilegeMapper.selectByExample(example);

		return list;
	}

	// 根据id 进行删除
	@Override
	public void deleteById(long id) throws CustomerException {

		BasePrivilege basePrivilege = basePrivilegeMapper.selectByPrimaryKey(id);

		if (basePrivilege == null) {

			throw new CustomerException("要删除的分类信息不存在");

		}

		basePrivilegeMapper.deleteByPrimaryKey(id);

	}

}
