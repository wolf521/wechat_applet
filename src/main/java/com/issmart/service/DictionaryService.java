package com.issmart.service;

import com.issmart.model.Dictionary;

public interface DictionaryService {
	
	/**
	 * 查询字典信息
	 * 
	 * @param unitId
	 * @param elementCode
	 * @return
	 */
	Dictionary queryDictionary(String unitId,String elementCode);
}
