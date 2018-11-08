package com.issmart.dao;

import org.apache.ibatis.annotations.Param;

import com.issmart.model.Dictionary;

public interface DictionaryDao {

	/**
	 * 查询字典信息
	 * 
	 * @param unitId
	 * @param elementCode
	 * @return
	 */
	Dictionary queryDictionary(@Param("unitId") String unitId,@Param("elementCode") String elementCode);
}
