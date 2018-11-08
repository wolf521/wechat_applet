package com.issmart.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.issmart.dao.MemberDao;
import com.issmart.dao.ScanDao;
import com.issmart.model.MemberLabel;
import com.issmart.model.ScanInfo;
import com.issmart.service.ScanService;
import com.issmart.util.MyBatisUtil;

public class ScanServiceImpl implements ScanService {

	@Override
	public Map<String,Object>  queryRule(String unitId) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		ScanDao scanDao = session.getMapper(ScanDao.class);
		return scanDao.queryRule(unitId);
	}

	@Override
	public List<Map<String, Object>> queryMemberInfoFromScan(List<ScanInfo> scanInfoList) {
		Collections.sort(scanInfoList, new Comparator<ScanInfo>() {

			@Override
			public int compare(ScanInfo o1, ScanInfo o2) {
				if (o1.getRssi() > o2.getRssi()) {
					return 1;
				}
				if (o1.getRssi() == o2.getRssi()) {
					return 0;
				}
				return -1;
			}
		});
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		ScanDao scanDao = session.getMapper(ScanDao.class);
		MemberDao memberDao = session.getMapper(MemberDao.class);
		List<Map<String, Object>> list = new ArrayList<>();
		for(ScanInfo scanInfo:scanInfoList) {
			Map<String, Object> map = scanDao.queryMemberInfoFromScan(scanInfo.getUnitId(),scanInfo.getTargetBeaconMac(),scanInfo.getBeaconCode(),scanInfo.getRssi());
			if(map == null) {
				continue;
			}
			List<MemberLabel> labelList = memberDao.queryLabel(map.get("id").toString());
			if(labelList.size() != 0) {
				map.put("labelName", labelList.get(0).getLabelName());
				map.put("labelCount", labelList.size());
			} else {
				map.put("labelName", "");
				map.put("labelCount", 0);
			}
			list.add(map);
		}
		return list;
	}
}
