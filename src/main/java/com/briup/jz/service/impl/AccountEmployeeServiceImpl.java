package com.briup.jz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountEmployee;
import com.briup.jz.dao.AccountEmployeeMapper;
import com.briup.jz.service.AccountEmployeeService;

@Service
public class AccountEmployeeServiceImpl implements AccountEmployeeService {

	@Autowired
	private AccountEmployeeMapper accountEmployeeMapper;
	

	@Override
	public void saveOrUpdate(AccountEmployee accountemployee) {
		if(accountemployee.getId()!=null) {
			accountEmployeeMapper.updateByPrimaryKey(accountemployee);
		}else{
			accountEmployeeMapper.insert(accountemployee);
		}

	}

	@Override
	public void deleteById(long id) {
		accountEmployeeMapper.deleteByPrimaryKey(id);

	}

	@Override
	public AccountEmployee queryAccountEmployeeById(long id) {
		
		return accountEmployeeMapper.selectByPrimaryKey(id);
	}

}
