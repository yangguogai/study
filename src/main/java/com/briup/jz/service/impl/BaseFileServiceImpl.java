package com.briup.jz.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.briup.jz.bean.BaseFile;
import com.briup.jz.bean.BaseFileExample;
import com.briup.jz.dao.BaseFileMapper;
import com.briup.jz.service.IBaseFileService;
import com.briup.jz.utils.CustomerException;


@Service
public class BaseFileServiceImpl implements IBaseFileService{
	@Autowired
	private BaseFileMapper baseFileMapper;

	@Override
	public void saveOrUpdate(BaseFile baseFile) throws CustomerException {
		if(baseFile.getId()!=null) {
			baseFileMapper.updateByPrimaryKey(baseFile);
		} else {
			// 判断是否有同名的分类，如果有抛出异常
			//BaseFileExample example = new BaseFileExample();
			//example.createCriteria().andFileNameEqualTo(baseFile.getFileName());
			//List<BaseFile> list = baseFileMapper.selectByExample(example);
			//if(list.size()>0) {
				//throw new CustomerException("同名的分类已存在");
			}
			baseFileMapper.insert(baseFile);
		}
	//}


	@Override
	public List<BaseFile> query(String filename) {
		BaseFileExample example = new BaseFileExample();
		if(filename!=null){
			example.createCriteria().andFileNameLike("%"+filename+"%");
		}
		List<BaseFile> list = baseFileMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(String id) throws CustomerException {
		BaseFile baseFile = baseFileMapper.selectByPrimaryKey(id);
		if(baseFile == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		baseFileMapper.deleteByPrimaryKey(id);
		
	}

}
