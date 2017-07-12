package com.fastdev.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * 业务方法执行日志
 */
@Aspect
@Component
public class ReqUidSyncAspect implements Ordered {

    @Pointcut("execution(public * net.fuqianla.easyquery..*Controller.*(..))")
    public void reqUidSyncGetPointcut() {
    }

    @Pointcut("execution(public * org.springframework.web.client.RestTemplate.postForEntity(..))")
    public void reqUidSyncSetPointcut() {
    }

    /**
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("reqUidSyncGetPointcut()")
    public Object doAroundGetPointcut(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        boolean needClearMDC = false;
        if (args != null) {
            for (Object arg : args) {
                if (arg instanceof GenericServiceDto) {
                    needClearMDC = true;
                    MDC.put("REQ_UID", ((GenericServiceDto) arg).getReqUID());
                    MDC.put("USER_CODE", ((GenericServiceDto) arg).getUserCode());
                    break;
                }
            }
        }

        Object result = point.proceed();

        if (needClearMDC) {
            MDC.remove("REQ_UID");
            MDC.remove("USER_CODE");
        }
        return result;
    }

    /**
     * @param point
     * @return
     * @throws Throwable
     */
    @Before("reqUidSyncSetPointcut()")
    public void beforeSetPointcut(JoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        if (args != null) {
            for (Object arg : args) {
                if (arg instanceof GenericServiceDto) {
                    ((GenericServiceDto) arg).setReqUID(MDC.get("REQ_UID"));
                    ((GenericServiceDto) arg).setUserCode(MDC.get("USER_CODE"));
                    break;
                }
            }
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }

}
