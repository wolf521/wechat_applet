package com.issmart.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.aliyun.fc.runtime.Context;
import com.issmart.dao.CommonDao;
import com.issmart.service.CommonService;
import com.issmart.util.BusinessUtil;
import com.issmart.util.MyBatisUtil;

public class CommonServiceImpl implements CommonService{

	@Override
	public String queryAccessToken(Context context,String appId) {
		// 获得会话对象
		SqlSession session = MyBatisUtil.getSqlSession(true);
		CommonDao commonDao = session.getMapper(CommonDao.class);
		String accessToken = commonDao.queryAccessToken(appId);
		if(accessToken == null) {
			accessToken = BusinessUtil.getAccessToken();
			if(commonDao.updateAccessToken(appId,accessToken) == 0) {
				commonDao.insertAccessToken(appId,accessToken);
			} else {
				//context.getLogger().info("更新accessToken："+accessToken);
			}
		}
		return accessToken;
	}
}
