package com.fastdev.jeesite.common.utils.excel.fieldtype;


import com.fastdev.jeesite.business.sys.entity.Area;
import com.fastdev.jeesite.business.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 字段类型转换
 */
public class AreaType {

	/**
	 * 获取对象值（导入）
	 */
	public static Object getValue(String val) {
		for (Area e : UserUtils.getAreaList()){
			if (StringUtils.trimToEmpty(val).equals(e.getName())){
				return e;
			}
		}
		return null;
	}

	/**
	 * 获取对象值（导出）
	 */
	public static String setValue(Object val) {
		if (val != null && ((Area)val).getName() != null){
			return ((Area)val).getName();
		}
		return "";
	}
}
