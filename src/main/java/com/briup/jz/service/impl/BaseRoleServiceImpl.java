package com.briup.jz.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.jz.bean.BaseRole;
import com.briup.jz.bean.BaseRoleExample;
import com.briup.jz.dao.BaseRoleMapper;
import com.briup.jz.service.IBaseRoleService;
import com.briup.jz.utils.CustomerException;

@Service
public class BaseRoleServiceImpl implements IBaseRoleService {
	
	@Autowired
	private BaseRoleMapper baseRoleMapper;
	

	// 保存或者更新操作
	@Override
	public void saveOrUpdate(BaseRole baseRole) throws CustomerException {
		
		if (baseRole.getId() != null) {
			
			baseRoleMapper.updateByPrimaryKey(baseRole);
			
		} else {

			BaseRoleExample example = new BaseRoleExample();
			
			example.createCriteria().andNameEqualTo(baseRole.getName());
			
			List<BaseRole> list = baseRoleMapper.selectByExample(example);
			
			if (list.size() > 0) {
				
				throw new CustomerException("同名的分类已存在");

			}
			baseRoleMapper.insert(baseRole);
		}

	}

	// 根据名字模糊查询
	@Override
	public List<BaseRole> query(String name) {

		BaseRoleExample example = new BaseRoleExample();
		
		if (name != null) {

			example.createCriteria().andNameLike("%" + name + "%");

		}
		List<BaseRole> list = baseRoleMapper.selectByExample(example);

		return list;
	}
	//根据id进行删除
	@Override
	public void deleteById(Long id) throws CustomerException {

		BaseRole baseRole = baseRoleMapper.selectByPrimaryKey(id);
		
		if (baseRole == null) {
			
			throw new CustomerException("要删除的分类信息不存在");

		}

		baseRoleMapper.deleteByPrimaryKey(id);

	}

}
