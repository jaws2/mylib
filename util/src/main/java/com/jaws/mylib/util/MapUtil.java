package com.jaws.mylib.util;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @Title Map Interface Toolkit 
 * @com.mylib.util MapUtil.java
 * @Describtion
 * @author jiangpan
 * @verson 1.0
 * @2016年12月28日 上午10:33:59
 */
public final class MapUtil {
	private static final Logger log = Logger.getLogger(MapUtil.class.getName());
	private MapUtil(){};
	/**
	 * 打印简单结构的Map
	 * @param map Map<K, V> K,V类型都需要重写toString方法
	 */
	public static <K,V> void printMap(final Map<K, V> map){
		if(map==null || map.isEmpty()){
			log.debug("Map is null or empty");
		}
		for(Map.Entry<K, V> entry : map.entrySet()){
			log.debug(entry.getKey().toString()+":"+entry.getValue().toString());
		}
	}

	
}
