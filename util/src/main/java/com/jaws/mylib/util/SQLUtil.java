package com.jaws.mylib.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title 与SQL相关的工具类
 * @com.jaws.mylib.util SQLUtil.java
 * @Describtion
 * @author jiangpan
 * @verson 1.0
 * @2016-12-29 下午2:35:51
 */
public class SQLUtil {
	
	/**
	 * 数据列表转换为sql中的in子句所用条件,支持批量转换
	 * @param dataList ArrayList<ArrayList<T>> 
	 * @return 返回 元素为'T1.toString()','T2.toString()','T3.toString()'这样格式SQL语句的列表
	 */
	public <T> ArrayList<String> convertDataToBatchSql(List<ArrayList<T>> dataList) {
		ArrayList<String> listSql = new ArrayList<String>();
		if (dataList == null || dataList.size() == 0) {
			return listSql;
		}
		for (int i = 0; i < dataList.size(); i++) {
			ArrayList<T> record = dataList.get(i);
			int j = 0;
			String sql = "";
			while (j < record.size()) {
				String value = record.get(j)!= null ? record.get(j).toString() : "";
				sql += "'" + value + "'";
				if (j != record.size() - 1) {
					sql += ",";
				}
				j++;
			}
			listSql.add(sql);
		}
		return listSql;
	}
	
	/**
	 * 数据列表转换为sql中的in子句所用条件
	 * @param datas  ArrayList<T>
	 * @return 返回 元素为'T1.toString()','T2.toString()','T3.toString()'这样格式的SQL语句
	 * @return
	 */
	public <T> String convertDataToSql(ArrayList<T> datas) {
		String sql = "";
		if (datas == null || datas.size() == 0) {
			return sql;
		}
		int j = 0;
		while (j < datas.size()) {
			String value = datas.get(j) != null ? datas.get(j).toString()
					: "";
			sql += "'" + value + "'";
			if (j != datas.size() - 1) {
				sql += ",";
			}
			j++;
		}
		return sql;
	}

}
