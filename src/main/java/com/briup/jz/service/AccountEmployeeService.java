package com.briup.jz.service;

import com.briup.jz.bean.AccountEmployee;

public interface AccountEmployeeService {
	
		//添加或者修改
		void saveOrUpdate(AccountEmployee accountemployee);
		
		//删除一个
		void deleteById(long id);
		
		//查询单个
		AccountEmployee queryAccountEmployeeById(long id);

}
