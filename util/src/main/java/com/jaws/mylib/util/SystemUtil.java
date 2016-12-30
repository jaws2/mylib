package com.jaws.mylib.util;

import java.util.Map;
import java.util.Properties;

/**
 * @Title 与操作系统相关的工具类
 * @com.jaws.mylib.util SystemUtil.java
 * @Describtion
 * @author jiangpan
 * @verson 1.0
 * @2016-12-29 下午2:35:20
 */
public class SystemUtil {
	/**
	  * 获取操作系统的某个环境变量的值
	  * @param varName 环境变量名称
	  * @return 设置的环境变量的值
	  */
	public static String getValueOfEvnVariable(String varName){
		Map<String, String> systemEnv = System.getenv();
		return systemEnv.get(varName) == null ? null : systemEnv.get(varName);
	}
		 
	/**
	 * 获取某个系统属性的值
	 * 
	 * @param propName
	 *            系统属性名称
	 * @return 某个系统属性的值
	 */
	public static String getSpecialProperty(String propName) {
		Properties systemProperties = System.getProperties();
		// Properties继承与HashTable,key不能用null,需先判断
		return propName == null ? null
				: systemProperties.getProperty(propName) == null ? null
						: systemProperties.getProperty(propName).toString();
	}
}
