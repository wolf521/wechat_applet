package com.issmart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.issmart.model.CardMessage;
import com.issmart.service.impl.CardServiceImpl;

public class CardServiceTest {

	@Test
	public void testQueryCardMessage() {
		CardService cardService = new CardServiceImpl();
		CardMessage cardMessage = new CardMessage();
		cardMessage.setUnitId("919");
		cardMessage.setBeaconMac("0CB2B74A0D1F");
		List<String> targetBeaconMacList = new ArrayList<>();
		targetBeaconMacList.add("01dada8c67");
		targetBeaconMacList.add("01dada960D");
		targetBeaconMacList.add("02dada8C5E");
		targetBeaconMacList.add("03dada8C3E");
		targetBeaconMacList.add("04dada8c67");
		targetBeaconMacList.add("05dada9617");
		targetBeaconMacList.add("06dada9955");
		cardMessage.setTargetBeaconMacList(targetBeaconMacList);
		List<Map<String, Object>> list = cardService.queryCardMessage(cardMessage);
		System.out.println(list);
	}
}
