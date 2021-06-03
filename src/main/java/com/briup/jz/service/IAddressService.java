package com.briup.jz.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.briup.jz.bean.Address;
import com.briup.jz.bean.Article;
import com.briup.jz.utils.CustomerException;

public interface IAddressService {
void saveOrUpdate(Address address) throws CustomerException;

List<Address> query(Address address);

Address queryAddressById(long id) throws CustomerException;

void deleteById(long id) throws CustomerException;

List<Address> query(String name);
	

	
	
}
