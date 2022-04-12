package com.jkard.jkexperiment.common.proxy;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {


    @Override
    public boolean before() {
        System.out.println("proxy before");
        return true;
    }

    @Override
    public boolean useAround() {
        return true;
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("proxy around before");
        Object result = invocation.proceed();
        System.out.println("proxy around after");
        return result;
    }

    @Override
    public void after() {
        System.out.println("proxy after");
    }

    @Override
    public void afterReturning() {
        System.out.println("proxy afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("proxy afterThrowing");
    }
}
