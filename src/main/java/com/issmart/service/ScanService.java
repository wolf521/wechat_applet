package com.issmart.service;

import java.util.List;
import java.util.Map;

import com.issmart.model.ScanInfo;

/**
 * 扫描服务
 * 1:被扫描者必须注册小程序才会有信息
 * 2:扫描人不能查询到自己的信息
 * 3:扫描设备分为android和ios，设备不同，扫描出来的数据格式和字段名称不同
 * @author Administrator
 *
 */
public interface ScanService {
	/**
	 * 查询扫描规则
	 * 
	 * @param unitId
	 * @return
	 */
	Map<String,Object>  queryRule(String unitId);
	
	/**
	 * 查询扫描信息
	 * 
	 * @param unitId
	 * @return
	 */
	List<Map<String,Object>> queryMemberInfoFromScan(List<ScanInfo> scanInfoList);
}
