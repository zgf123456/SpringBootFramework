package com.fastdev.common.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 业务方法执行日志
 */
@Aspect
@Component
public class LogAspect implements Ordered {

    @Pointcut("execution(public * com.fastdev..*Controller.*(..)) ||"
            + "execution(public * com.fastdev..*Service.*(..)) ")
    public void logPointcut() {
    }

    /**
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointcut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        Logger classLogger = LoggerFactory.getLogger(point.getTarget().getClass());
        String methodName = point.getSignature().getName();
        String methodParam = getMethodParam(point.getArgs(), methodName, classLogger);
        MDC.put("METHOD_PARAM", "参数值: " + methodParam);
        classLogger.debug("方法[" + methodName + "] 执行开始 ");
        MDC.put("METHOD_PARAM", "");
        //获取操作内容
        long startTime = System.currentTimeMillis();
        result = point.proceed();
        long endTime = System.currentTimeMillis();
        float usedTime = (float) (endTime - startTime) / 1000;
        String resultJson = getMethodReturn(result, methodName, classLogger);
        //后置通知
        MDC.put("METHOD_PARAM", "返回值：" + resultJson);
        classLogger.debug("方法[" + methodName + "] 执行结束 耗时:" + usedTime + "s ");
        MDC.put("METHOD_PARAM", "");
        return result;
    }

    /**
     * 获取方法参数JSON格式
     */
    private String getMethodParam(Object[] args, String mName, Logger classLogger) {
        StringBuffer rs = new StringBuffer("");
        try {
            if (args == null) {
                return null;
            }
            rs.append(mName);
            String className = null;
            int index = 1;
            //遍历参数对象
            for (Object info : args) {
                //排除response参数类型
                if (info == null || info instanceof HttpServletResponse) {
                    continue;
                }
                if (info instanceof HttpServletRequest) {
                    HttpServletRequest request = (HttpServletRequest) info;
                    info = request.getParameterMap();
                }
                //获取对象类型
                className = info.getClass().getName();
                className = className.substring(className.lastIndexOf(".") + 1);
                rs.append("[参数" + index + "，类型:" + className + "，值:");
                rs.append(JSON.toJSONString(info));
                rs.append("]");
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            classLogger.debug("获取[" + mName + "]方法参数JSON格式异常:", e);
        }
        return rs.toString();
    }

    /**
     * 获取方法返回值JSON格式
     */
    private String getMethodReturn(Object obj, String mName, Logger classLogger) {
        StringBuffer rs = new StringBuffer("");
        try {
            JSON.toJSONString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            classLogger.debug("获取[" + mName + "]方法返回值JSON格式异常:", e);
        }
        return rs.toString();
    }

    @Override
    public int getOrder() {
        return 999;
    }


}
