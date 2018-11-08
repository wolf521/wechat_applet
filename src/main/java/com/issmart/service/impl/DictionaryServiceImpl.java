package com.issmart.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.issmart.dao.DictionaryDao;
import com.issmart.model.Dictionary;
import com.issmart.service.DictionaryService;
import com.issmart.util.MyBatisUtil;

public class DictionaryServiceImpl implements DictionaryService {

	@Override
	public Dictionary queryDictionary(String unitId, String elementCode) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		DictionaryDao dictionaryDao = session.getMapper(DictionaryDao.class);
		return dictionaryDao.queryDictionary(unitId, elementCode);
	}
}
