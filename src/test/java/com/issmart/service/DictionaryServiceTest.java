package com.issmart.service;

import org.junit.Test;

import com.issmart.model.Dictionary;
import com.issmart.service.impl.DictionaryServiceImpl;

public class DictionaryServiceTest {

	@Test
	public void testQueryDictionary() {
		DictionaryService dictionaryService = new DictionaryServiceImpl();
		Dictionary d = dictionaryService.queryDictionary("919", "industry");
		System.out.println(d);
	}

}
