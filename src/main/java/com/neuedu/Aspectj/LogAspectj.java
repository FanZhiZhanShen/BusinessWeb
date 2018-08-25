package com.neuedu.Aspectj;

import com.neuedu.dao.LogAspectjDao;
import com.neuedu.entity.LogAspectJ;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class LogAspectj {
    @Autowired
    LogAspectjDao logAspectjDao;

    @Pointcut("execution(* com.neuedu.service.impl.*.*(..))")
    public  void log(){}

    @Around("log()")
    public void around(ProceedingJoinPoint pjp){
        String calssName=pjp.getTarget().getClass().getName();
        String calssMethod=pjp.getSignature().getName();
        try {
            Object o =pjp.proceed();
            LogAspectJ logAspectJ=new LogAspectJ(1, new Date(),calssName+calssMethod);
            logAspectjDao.add(logAspectJ);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
