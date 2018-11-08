package com.issmart.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.issmart.dao.ActiveDao;
import com.issmart.model.BeaconActive;
import com.issmart.service.ActiveService;
import com.issmart.util.MyBatisUtil;

public class ActiveServiceImpl implements ActiveService {

	@Override
	public List<BeaconActive> queryActive(String unitId, String beaconCode) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		ActiveDao activeDao = session.getMapper(ActiveDao.class);
		String beaconMac = activeDao.getBeaconMac(unitId, beaconCode);
		List<BeaconActive> list = activeDao.queryBehaviorBtn(unitId, beaconMac);
		list.addAll(activeDao.queryBehaviorCard(unitId, beaconMac,beaconCode));
		list.addAll(activeDao.queryBehaviorFriends(unitId,beaconCode));
		Collections.sort(list, new Comparator<BeaconActive>() {
			@Override
			public int compare(BeaconActive o1, BeaconActive o2) {
				if (o1.getLeaveTime().getTime() > o2.getLeaveTime().getTime()) {
					return 1;
				}
				if (o1.getLeaveTime().getTime() == o2.getLeaveTime().getTime()) {
					return 0;
				}
				return -1;
			}
		});
		return list;
	}

	/**
	 * 处理轨迹信息数据
	 * 
	 * @param unitId
	 * @param beaconMac
	 * @return
	 */
	public LinkedList<BeaconActive> handleActiveData(String unitId, String beaconMac, ActiveDao activeDao) {
		List<BeaconActive> list = activeDao.queryActive(unitId, beaconMac);
		LinkedList<BeaconActive> activeList = new LinkedList<BeaconActive>();
		list.get(0).setEventName("参观" + list.get(0).getBoothName() + "展台");
		activeList.add(list.get(0));
		for (BeaconActive beaconActive : list) {
			BeaconActive lastBeaconActive = activeList.getLast();
			if (!beaconActive.getDeviceMac().equals(lastBeaconActive.getDeviceMac())
					|| !judgeIffiveMin(beaconActive.getLeaveTime(), lastBeaconActive.getLeaveTime())) {
				beaconActive.setEventName("参观" + beaconActive.getBoothName() + "展台");
				activeList.addLast(beaconActive);
			}
		}
		return activeList;
	}

	/**
	 * 判断两个时间差是否相差5分钟
	 * 
	 * @return
	 */
	private static boolean judgeIffiveMin(Date d1, Date d2) {
		return (d1.getTime() - d2.getTime()) <= 300000l;
	}
}
