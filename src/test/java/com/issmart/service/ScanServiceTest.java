package com.issmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.issmart.model.ScanInfo;
import com.issmart.service.impl.ScanServiceImpl;
import com.issmart.util.StringUtil;

public class ScanServiceTest {

	@Test
	public void testQueryRule() {
		ScanService scanService = new ScanServiceImpl();
		Map<String,Object> list = scanService.queryRule("919");
		System.out.println(list);
	}
	
	@Test
	public void queryMemberInfoFromScan() {
		ScanService scanService = new ScanServiceImpl();
		List<ScanInfo> scanInfoList = new ArrayList<>();
		ScanInfo scanInfo = new ScanInfo();
		scanInfo.setUnitId("919");
		scanInfo.setRssi(68);
		scanInfo.setDeviceId("sdwefder-0F070D2564F2ddddewerewrc");
		scanInfo.setBeaconCode("00353");
		scanInfo.setPlatform("ios");
		scanInfo.setServiceDate("F166250D-070F-0807-0605-FF011A544D53");
		scanInfoList.add(scanInfo);
		ScanInfo scanInfo1 = new ScanInfo();
		scanInfo1.setUnitId("919");
		scanInfo1.setRssi(65);
		scanInfo1.setDeviceId("sdwefder-0F070D2564F2ddddewerewrc");
		scanInfo1.setBeaconCode("801278");
		scanInfo1.setPlatform("ios");
		scanInfo1.setServiceDate("F166250D-070F-0807-0605-FF011A544D53");
		scanInfoList.add(scanInfo1);
		ScanInfo scanInfo2 = new ScanInfo();
		scanInfo2.setUnitId("919");
		scanInfo2.setRssi(70);
		scanInfo2.setDeviceId("44:A4:89:F0:20:8B");
		scanInfo2.setBeaconCode("801278");
		scanInfo2.setPlatform("android");
		scanInfoList.add(scanInfo2);
		ScanInfo scanInfo3 = new ScanInfo();
		scanInfo3.setUnitId("919");
		scanInfo3.setRssi(54);
		scanInfo3.setDeviceId("44:A4:89:F0:20:8B");
		scanInfo3.setBeaconCode("801278");
		scanInfo3.setPlatform("android");
		scanInfoList.add(scanInfo3);
		List<Map<String,Object>> list = scanService.queryMemberInfoFromScan(scanInfoList);
		System.out.println(list);
	}
	

	public static void main(String[] args) { 
		System.out.println(StringUtil.getReverse("F0F8F2DA9B0D"));
	}
}
