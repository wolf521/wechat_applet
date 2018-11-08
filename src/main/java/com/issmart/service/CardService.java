package com.issmart.service;

import java.util.List;
import java.util.Map;

import com.issmart.model.CardMessage;

/**
 * 名片服务
 * 
 * @author Administrator
 *
 */
public interface CardService {
		
	List<Map<String, Object>> queryCardMessage(CardMessage cardMessage);
}
