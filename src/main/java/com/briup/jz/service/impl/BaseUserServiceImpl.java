package com.briup.jz.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.jz.bean.BaseUser;
import com.briup.jz.bean.BaseUserExample;
import com.briup.jz.dao.BaseUserMapper;
import com.briup.jz.service.IBaseUserService;
import com.briup.jz.utils.CustomerException;


@Service
public class BaseUserServiceImpl implements IBaseUserService {
	
	@Autowired
	private BaseUserMapper baseUserMapper;
	

	// 保存或者更新操作
	@Override
	public void saveOrUpdate(BaseUser baseUser) throws CustomerException {
		
		if (baseUser.getId() != null) {
			
			baseUserMapper.updateByPrimaryKey(baseUser);

		} else {
			// 判断是否有同名的分类，如果有抛出异常

			BaseUserExample example = new BaseUserExample();
			
			example.createCriteria().andUsernameEqualTo(baseUser.getUsername());
			
			List<BaseUser> list = baseUserMapper.selectByExample(example);
			
			if (list.size() > 0) {
				
				throw new CustomerException("同名的分类已存在");

			}

			baseUserMapper.insert(baseUser);
		}

	}

	// 根据名字模糊查询
	@Override
	public List<BaseUser> query(String username) {

		BaseUserExample example = new BaseUserExample();
		
		if (username != null) {
			
			example.createCriteria().andUsernameLike("%" + username + "%");

		}
		List<BaseUser> list = baseUserMapper.selectByExample(example);

		return list;
	}

	// 根据id进行删除
	@Override
	public void deleteById(Long id) throws CustomerException {

		BaseUser baseUser = baseUserMapper.selectByPrimaryKey(id);
		
		if (baseUser == null) {
			
			throw new CustomerException("要删除的分类信息不存在");

		}

		baseUserMapper.deleteByPrimaryKey(id);

	}

}
