package com.issmart.service;

import java.util.List;

import org.junit.Test;

import com.issmart.model.BeaconActive;
import com.issmart.service.impl.ActiveServiceImpl;

public class ActiveServiceTest {

	@Test
	public void testQueryActive() {
		ActiveService activeService = new ActiveServiceImpl();
		List<BeaconActive> list = activeService.queryActive("919", "00330");
		System.out.println(list);
	}
}
