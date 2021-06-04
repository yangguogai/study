package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountApplyExample;
import com.briup.jz.dao.AccountApplyMapper;
import com.briup.jz.service.AccountApplyService;
import com.briup.jz.utils.CustomerException;

@Service
public class AccountApplyServiceImpl implements AccountApplyService {

	@Autowired
	private AccountApplyMapper accountApplyMapper;

	// 根据id查询银行账户充值提现信息
	@Override
	public AccountApply queryAccountApplyByid(long id) {

		return accountApplyMapper.selectByPrimaryKey(id);
	}

	// 存取或者修改
	@Override
	public void saveOrUpdate(AccountApply accountApply) {

		if (accountApply.getId() != null) {
			accountApplyMapper.updateByPrimaryKey(accountApply);
		} else {
			accountApplyMapper.insert(accountApply);
		}

	}

	// 删除一个id信息
	@Override
	public void deleteById(long id) throws CustomerException {
		AccountApply accountApply = accountApplyMapper.selectByPrimaryKey(id);
		if (accountApply == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		accountApplyMapper.deleteByPrimaryKey(id);
	}

	// 根据提现、重置、审核状态去模糊查询记录
	@Override
	public List<AccountApply> query(String ApplyType, String status) {
		AccountApplyExample example = new AccountApplyExample();
		if (ApplyType != null) {
			example.createCriteria().andApplyTypeLike("%" + ApplyType + "%");
		}
		if (status != null) {
			example.createCriteria().andApplyTypeLike("%" + status + "%");
		}
		List<AccountApply> list = accountApplyMapper.selectByExample(example);
		return list;
	}

}
