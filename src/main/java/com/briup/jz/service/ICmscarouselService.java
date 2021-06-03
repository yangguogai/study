package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Carousel;
import com.briup.jz.bean.CarouselExample;
import com.briup.jz.bean.Category;
import com.briup.jz.utils.CustomerException;

public interface ICmscarouselService {
	//存储或者更新一个用户的在线状态和IP地址
	void saveOrUpdate(Carousel cmscarousel) throws CustomerException;

		//根据id查询用户的IP地址和在线状态
	 List<Carousel> selectByExample(CarouselExample example);
		
		//根据id删除一个用户IP地址和在线状态
		void deleteById(long id) throws CustomerException;
		

}
