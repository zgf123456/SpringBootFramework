package com.fastdev.jeesite.business.sys.utils;

import com.fastdev.jeesite.business.sys.entity.Log;
import com.fastdev.jeesite.business.sys.entity.User;
import com.fastdev.jeesite.business.sys.interceptor.InterceptorLogEntity;
import com.fastdev.jeesite.business.sys.interceptor.LogThread;
import com.fastdev.jeesite.common.utils.StringUtilsExt;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 字典工具类
 */
public class LogUtils {

    public static final String CACHE_MENU_NAME_PATH_MAP = "menuNamePathMap";

    /**
     * 保存日志
     */
    public static void saveLog(HttpServletRequest request, String title) {
        saveLog(request, null, null, title);
    }

    /**
     * 保存日志
     */
    public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title) {
        User user = UserUtils.getUser();
        if (user != null && user.getId() != null) {
            Log log = new Log();
            log.setTitle(title);
            log.setType(ex == null ? Log.TYPE_ACCESS : Log.TYPE_EXCEPTION);
            log.setRemoteAddr(StringUtilsExt.getRemoteAddr(request));
            log.setUserAgent(request.getHeader("user-agent"));
            log.setRequestUri(request.getRequestURI());
            log.setParams(request.getParameterMap());
            log.setMethod(request.getMethod());
            log.setCreateBy(user);
            log.setUpdateBy(user);
            log.setUpdateDate(new Date());
            log.setCreateDate(new Date());
            // 异步保存日志
            try {
                InterceptorLogEntity entiry = new InterceptorLogEntity(log, handler, ex);
                LogThread.interceptorLogQueue.put(entiry);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
