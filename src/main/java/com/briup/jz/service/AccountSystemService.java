package com.briup.jz.service;

import com.briup.jz.bean.AccountSystem;

public interface AccountSystemService {

			//添加或者修改
			void saveOrUpdate(AccountSystem AccountSystem);
			
			//删除一个
			void deleteById(long id);
			
			//查询单个
			AccountSystem queryAccountSystemById(long id);

}
