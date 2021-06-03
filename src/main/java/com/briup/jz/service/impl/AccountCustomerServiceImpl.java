package com.briup.jz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountApply;
import com.briup.jz.bean.AccountCustomer;
import com.briup.jz.dao.AccountApplyMapper;
import com.briup.jz.dao.AccountCustomerMapper;
import com.briup.jz.service.AccountApplyService;
import com.briup.jz.service.AccountCustomerService;

@Service
public class AccountCustomerServiceImpl implements AccountCustomerService {

	@Autowired
	private AccountCustomerMapper accountCustomerMapper;

	@Override
	public void saveOrUpdate(AccountCustomer accountCustomer) {
		if(accountCustomer.getId()!=null) {
			accountCustomerMapper.updateByPrimaryKey(accountCustomer);
		}else{
			accountCustomerMapper.insert(accountCustomer);
		}
		
	}

	@Override
	public void deleteById(long id) {
		accountCustomerMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public AccountCustomer queryAccountCustomerById(long id) {
		
		return accountCustomerMapper.selectByPrimaryKey(id);
	}

	

}
