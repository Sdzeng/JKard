package com.jkard.jkexperiment.common;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {


    @Override
    public boolean before() {
        System.out.println("before");
        return true;
    }

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before");
        Object result = invocation.proceed();
        System.out.println("around after");
        return result;
    }

    @Override
    public void after() {
        System.out.println("after");
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }
}
