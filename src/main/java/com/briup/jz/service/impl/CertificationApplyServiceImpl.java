package com.briup.jz.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.jz.bean.CertificationApply;
import com.briup.jz.bean.CertificationApplyExample;
import com.briup.jz.dao.CertificationApplyMapper;
import com.briup.jz.service.ICertificationApplyService;
import com.briup.jz.utils.CustomerException;

@Service
public class CertificationApplyServiceImpl implements ICertificationApplyService {

	@Autowired
	private CertificationApplyMapper certificationApplyMapper;

	// 保存或者更新操作
	@Override
	public void saveOrUpdate(CertificationApply certificationApply) throws CustomerException {

		if (certificationApply.getId() != null) {
			certificationApplyMapper.updateByPrimaryKey(certificationApply);

		} else {

			// 判断是否有同名的分类，如果有抛出异常 模板
			CertificationApplyExample example = new CertificationApplyExample();

			example.createCriteria().andRealnameEqualTo(certificationApply.getRealname());

			List<CertificationApply> list = certificationApplyMapper.selectByExample(example);

			if (list.size() > 0) {
				throw new CustomerException("同名的分类已存在");
			}
			certificationApplyMapper.insert(certificationApply);

		}

	}

	// 根据名字模糊查询
	@Override
	public List<CertificationApply> query(String realname) {

		// 模板 查询所有

		CertificationApplyExample example = new CertificationApplyExample();

		if (realname != null) {
//			example.createCriteria().andRealnameEqualTo("%" + name + "%");
			example.createCriteria().andRealnameLike("%" + realname + "%");
		}

		List<CertificationApply> list = certificationApplyMapper.selectByExample(example);

		return list;

	}

	// 根据id进行删除
	@Override
	public void deleteById(long id) throws CustomerException {

		CertificationApply certificationApply = certificationApplyMapper.selectByPrimaryKey(id);
		if (certificationApply == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		certificationApplyMapper.deleteByPrimaryKey(id);
	}

}
