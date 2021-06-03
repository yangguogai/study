package com.briup.jz.service;

import com.briup.jz.bean.AccountCustomer;

public interface AccountCustomerService {
	
	//添加或者修改
	void saveOrUpdate(AccountCustomer accountCustomer);
	
	//删除一个
	void deleteById(long id);
	
	//查询单个
	AccountCustomer queryAccountCustomerById(long id);

}
