package com.briup.jz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.AccountSystem;
import com.briup.jz.dao.AccountSystemMapper;
import com.briup.jz.service.AccountSystemService;

@Service
public class AccountSystemServiceImpl implements AccountSystemService {

	@Autowired
	private AccountSystemMapper accountSystemMapper;

	@Override
	public void saveOrUpdate(AccountSystem accountSystem) {
		if (accountSystem.getId() != null) {
			accountSystemMapper.updateByPrimaryKey(accountSystem);
		} else {
			accountSystemMapper.insert(accountSystem);
		}

	}

	@Override
	public void deleteById(long id) {
		accountSystemMapper.deleteByPrimaryKey(id);

	}

	@Override
	public AccountSystem queryAccountSystemById(long id) {

		return accountSystemMapper.selectByPrimaryKey(id);
	}

}
