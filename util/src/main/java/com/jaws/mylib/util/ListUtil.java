package com.jaws.mylib.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @Title List Interface Toolkit 
 * @com.jaws.mylib.util ListUtil.java
 * @Describtion
 * @author jiangpan
 * @version 1.0
 * @2016年12月28日 上午10:35:06
 */
public final class ListUtil {
	
	private static final Logger log = Logger.getLogger(ListUtil.class);
	private ListUtil(){};
	
	/**
	 * 打印列表里面元素
	 * 
	 * @param list 元素需要重写toString方法
	 * void
	 */
	public static <T> void printSimpleList(List<T> list){
		if (list == null || list.size() == 0 ) {
			return;
		}
		for (T t : list) {
			log.debug(t.toString());
		}
	}
	
	/**
	 * 数组列表转换为单个元素的列表
	 * @param listArray ArrayList<T[]> 数组列表
	 * @param index int 指定元素在数组中的索引
	 * @return
	 */
	public static <T> List<T> listArrayToList(ArrayList<T[]> listArray,
			int index) {
		ArrayList<T> rtnList = new ArrayList<T>();
		if (listArray == null) {
			return null;
		}
		if (listArray.size() == 0 || index > listArray.get(0).length) {
			return rtnList;
		}
		for (T[] array : listArray) {
			T targetStr = array[index];
			rtnList.add(targetStr);
		}
		return rtnList;
	}
	
	/**
	 * 数组列表转换为数组中两个元素组成的Map
	 * <p>Key,Value都是数组中的元素,是同一类型<p>
	 * @param listArray 
	 * @param keyIndex Key在数组中的索引
	 * @param valueIndex Value在数组中的索引
	 * @return
	 */
	public static <T> Map<T, T> listArrayToMap(ArrayList<T[]> listArray,
			int keyIndex, int valueIndex) {
		Map<T, T> rtnMap = new HashMap<T, T>();
		if (listArray == null) {
			return null;
		}
		if (listArray.size() == 0 || keyIndex > listArray.get(0).length
				|| valueIndex > listArray.get(0).length) {
			return rtnMap;
		}
		for (T[] arr : listArray) {
			T key = arr[keyIndex];
			T value = arr[valueIndex];
			rtnMap.put(key, value);
		}
		return rtnMap;
	}
	
	
	/**
	 * 去掉List中的重复元素
	 * @param list List<T>ֵ
	 * @return
	 */
	public static <T> List<T> removeDuplicate(List<T> list){
		if (list == null) {
			return null;
		}
		if (list.size() == 0) {
			return list;
		}
		Set<T> cacheSet = new HashSet<T>(list);
		list.clear();
		list.addAll(cacheSet);
		return list;
	}
	
	/**
	 * 去掉List中的重复元素
	 * @param list List<T> 
	 */
	public static <T> void unDuplicate(List<T> list){
		if (list == null) {
			throw new NullPointerException();
		}
		Set<T> cacheSet = new HashSet<T>(list);
		list.clear();
		list.addAll(cacheSet);
	}
}
