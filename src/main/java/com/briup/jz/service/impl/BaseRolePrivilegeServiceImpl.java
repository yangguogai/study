package com.briup.jz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.jz.bean.BaseRolePrivilege;
import com.briup.jz.bean.BaseRolePrivilegeExample;
import com.briup.jz.dao.BaseRolePrivilegeMapper;
import com.briup.jz.service.IBaseRolePrivilegeService;
import com.briup.jz.utils.CustomerException;

@Service
public class BaseRolePrivilegeServiceImpl implements IBaseRolePrivilegeService {

	@Autowired
	private BaseRolePrivilegeMapper baseRolePrivilegeMapper;

	// 保存或者更新操作
	@Override
	public void saveOrUpdate(BaseRolePrivilege baseRolePrivilege) throws CustomerException {

		if (baseRolePrivilege.getId() != null) {

			baseRolePrivilegeMapper.updateByPrimaryKey(baseRolePrivilege);

		} else {
			// 判断是否有同名的分类，如果有抛出异常

			BaseRolePrivilegeExample example = new BaseRolePrivilegeExample();

			example.createCriteria().andIdEqualTo(baseRolePrivilege.getId());

			List<BaseRolePrivilege> list = baseRolePrivilegeMapper.selectByExample(example);

			if (list.size() > 0) {
				throw new CustomerException("同名的分类已存在");
			}
			baseRolePrivilegeMapper.insert(baseRolePrivilege);
		}

	}

	// 根据id 查询
	@Override
	public List<BaseRolePrivilege> query(Long id) {
		BaseRolePrivilegeExample example = new BaseRolePrivilegeExample();

		if (id != null) {

			example.createCriteria().andIdEqualTo(id);
		}
		List<BaseRolePrivilege> list = baseRolePrivilegeMapper.selectByExample(example);

		return list;
	}

	// 根据id 进行删除
	@Override
	public void deleteById(long id) throws CustomerException {

		BaseRolePrivilege baseRolePrivilege = baseRolePrivilegeMapper.selectByPrimaryKey(id);

		if (baseRolePrivilege == null) {

			throw new CustomerException("要删除的分类信息不存在");
		}
		baseRolePrivilegeMapper.deleteByPrimaryKey(id);
	}

}
