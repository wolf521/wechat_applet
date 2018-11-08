package com.issmart.service;

import org.junit.Test;

import com.issmart.service.impl.BoothServiceImpl;

public class BoothServiceTest {

	@Test
	public void testGetBooothDetail() {
		BoothService boothService = new BoothServiceImpl();
		System.out.println(boothService.getBooothDetail("919", "00:1f:c2:26:55:85"));
	}
	
	@Test
	public void testGetUnitId() {
		BoothService boothService = new BoothServiceImpl();
		System.out.println(boothService.getUnitId("01021"));
	}
	
	@Test
	public void testQueryBoothInfo() {
		BoothService boothService = new BoothServiceImpl();
		System.out.println(boothService.queryBoothInfo());
	}
	
}
