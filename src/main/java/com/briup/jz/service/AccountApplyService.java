package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.AccountApply;

public interface AccountApplyService {

	//根据id查询银行账户充值提现信息
	AccountApply queryAccountApplyByid(long id);
	
	//增加或者修改一个银行账户充值提现信息
	void saveOrUpdate(AccountApply accountApply);
	
	//根据数据库记录操作id删除一个银行账户充值提现信息
	void deleteById(long id);
	
}
