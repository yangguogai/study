package com.briup.jz.service;

import com.briup.jz.bean.Platform;

public interface PlatformService {
	//添加或者修改
	void saveOrUpdate(Platform Platform);
	
	//删除一个
	void deleteById(long id);
	
	//查询单个
	Platform queryPlatformById(long id);
}
