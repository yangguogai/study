package com.briup.jz.service;
import java.util.List;
import com.briup.jz.bean.CertificationApply;
import com.briup.jz.utils.CustomerException;
public interface ICertificationApplyService {
	// 存储或者更新一个....
	void saveOrUpdate(CertificationApply certificationApply) throws CustomerException;

	// 根据名字模糊查询
	List<CertificationApply> query(String realname);

	// 根据id删除一个
	void deleteById(long id) throws CustomerException;
}
