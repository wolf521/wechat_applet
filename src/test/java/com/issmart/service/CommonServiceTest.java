package com.issmart.service;

import org.junit.Test;

import com.issmart.service.impl.CommonServiceImpl;

public class CommonServiceTest {

	@Test
	public void testQueryActive() {
		CommonService commonService = new CommonServiceImpl();
		System.out.println(commonService.queryAccessToken(null, "wxc1f17015fdcb2e73"));
	}
}
