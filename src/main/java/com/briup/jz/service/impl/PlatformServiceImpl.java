package com.briup.jz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Platform;
import com.briup.jz.dao.PlatformMapper;
import com.briup.jz.service.PlatformService;

@Service
public class PlatformServiceImpl implements PlatformService {

	@Autowired
	private PlatformMapper platformMapper;

	@Override
	public void saveOrUpdate(Platform Platform) {
		if (Platform.getId() != null) {
			platformMapper.updateByPrimaryKey(Platform);
		} else {
			platformMapper.insert(Platform);
		}

	}

	@Override
	public void deleteById(long id) {
		platformMapper.deleteByPrimaryKey(id);

	}

	@Override
	public Platform queryPlatformById(long id) {

		return platformMapper.selectByPrimaryKey(id);
	}

}
