package com.mytest.permission;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AOPAspect {
    @Autowired
    PermisssionUtils utils;

    public Object checkPermission(ProceedingJoinPoint pjp) throws Throwable {
        if (null == utils.userId()) {
            throw new UNAUTHORIZED();
        } else {
            MethodSignature msig = (MethodSignature) pjp.getSignature();
            String resourceName = pjp.getTarget().getClass().getMethod(msig.getName(), msig.getParameterTypes()).getAnnotation(ResourceAs.class).value();
            if (utils.hasResource(resourceName)) {
                return pjp.proceed();
            } else {
                throw new FORBIDDEN();
            }
        }
    }
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    private static class UNAUTHORIZED extends Exception {
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    private static class FORBIDDEN extends Exception {
    }
}
