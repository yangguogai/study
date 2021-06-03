package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.dao.AccountApplyMapper;
import com.briup.jz.service.AccountApplyService;

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
	public void deleteById(long id) {

		accountApplyMapper.deleteByPrimaryKey(id);

	}

}
