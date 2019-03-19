package com.prateek.reap.aop;


import lombok.val;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.framework.AopProxyUtils;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;

@Aspect
public class TimeStampAspect {

    @Before("execution(public * com.prateek.reap.Repository.* +.*(..))")
    public void setTimeStamp(JoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if (!signature.getName().contains("save")) {
            return;
        }

        Class<?> domainRepositoryType = AopProxyUtils.proxiedUserInterfaces(joinPoint.getTarget())[0];

        Class<?> entityType = (Class<?>) ((ParameterizedType) domainRepositoryType.getGenericInterfaces()[0]).getActualTypeArguments()[0];

        if (!TimestampAware.class.isAssignableFrom(entityType)) {
            return;
        }

        val argBeingSaved = joinPoint.getArgs()[0];

        // save (single object or iteralbe of objects)
        if (argBeingSaved instanceof Iterable) {
            timestampAll((Iterable<TimestampAware<?>>) argBeingSaved);
        } else {
            timestampOne((TimestampAware<?>) argBeingSaved);
        }

    }

    private void timestampAll(Iterable<TimestampAware<?>> entities) {
        entities.forEach(this::timestampOne);
    }

    private void timestampOne(TimestampAware<?> withCreatedAt) {
        val now = LocalDateTime.now();

        if (withCreatedAt.getId() == null) {
            withCreatedAt.setCreatedAt(now);
        }
        withCreatedAt.setUpdatedAt(now);


    }

}
