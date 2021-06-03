package com.briup.jz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Carousel;
import com.briup.jz.bean.CarouselExample;
import com.briup.jz.bean.Category;
import com.briup.jz.bean.CategoryExample;
import com.briup.jz.dao.CarouselMapper;
import com.briup.jz.dao.CategoryMapper;
import com.briup.jz.service.ICarouselService;
import com.briup.jz.utils.CustomerException;
@Service
public class CarouselServiceImpl implements ICarouselService{
 @Autowired
 private CarouselMapper carouselMapper;

 @Override
 public void saveOrUpdate(Carousel carousel) throws CustomerException {
  if(carousel.getId()!=null) {
   carouselMapper.updateByPrimaryKey(carousel);
  } else {
   // 判断是否有同名的分类，如果有抛出异常
   CarouselExample example = new CarouselExample();
   example.createCriteria().andNameEqualTo(carousel.getName());
   List<Carousel> list = carouselMapper.selectByExample(example);
   if(list.size()>0) {
    throw new CustomerException("同名的分类已存在");
   }
   carouselMapper.insert(carousel);
  }
 }

 @Override
 public List<Carousel> query(String name) {
  CarouselExample example = new CarouselExample();
  if(name!=null){
   example.createCriteria().andNameLike("%"+name+"%");
  }
  List<Carousel> list = carouselMapper.selectByExample(example);
  return list;
 }
 @Override
 public void deleteById(long id) throws CustomerException {
  Carousel carousel = carouselMapper.selectByPrimaryKey(id);
  if(carousel == null) {
   throw new CustomerException("要删除的分类信息不存在");
  }
  carouselMapper.deleteByPrimaryKey(id);
  
 }

}