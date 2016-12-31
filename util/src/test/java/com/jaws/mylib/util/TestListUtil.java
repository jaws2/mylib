package com.jaws.mylib.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TestListUtil {
	
	Logger log = Logger.getLogger(TestListUtil.class.getName());

	@Test
	public void unDuplicateTest() {
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("111");
		list.add("222");
		ListUtil.unDuplicate(list);
		for (String str : list) {
			log.debug(str);
		}
	}

	@Test
	public void removeDuplicateTest() {
		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("111");
		list.add("222");
		list.add("333");
		Assert.assertNotNull("空的", list);
		List<String> listResult = ListUtil.removeDuplicate(list);
		for (String str : listResult) {
			log.debug(str);
		}
	}
}
