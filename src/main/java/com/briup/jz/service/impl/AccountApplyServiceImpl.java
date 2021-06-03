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

	// 根据id查询银行账户充值提现信息1234
	@Override
	public AccountApply queryAccountApplyByid(long id) {

		return accountApplyMapper.selectByPrimaryKey(id);
	}

	//
	@Override
	public void saveOrUpdate(AccountApply accountApply) {
		
		if(accountApply.getId()!=null) {
			accountApplyMapper.updateByPrimaryKey(accountApply);
		}else {
			
		}

	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub

	}

}
