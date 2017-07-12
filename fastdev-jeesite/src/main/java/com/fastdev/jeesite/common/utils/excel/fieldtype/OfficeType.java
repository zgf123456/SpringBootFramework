package com.fastdev.jeesite.common.utils.excel.fieldtype;


import com.fastdev.jeesite.business.sys.entity.Office;
import com.fastdev.jeesite.business.sys.utils.UserUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 字段类型转换
 */
public class OfficeType {

    /**
     * 获取对象值（导入）
     */
    public static Object getValue(String val) {
        for (Office e : UserUtils.getOfficeList()) {
            if (StringUtils.trimToEmpty(val).equals(e.getName())) {
                return e;
            }
        }
        return null;
    }

    /**
     * 设置对象值（导出）
     */
    public static String setValue(Object val) {
        if (val != null && ((Office) val).getName() != null) {
            return ((Office) val).getName();
        }
        return "";
    }
}
