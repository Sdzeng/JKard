package com.jkard.jkexperiment.common.proxy;

import java.lang.reflect.InvocationTargetException;

public interface Interceptor {
    public boolean before();

    public boolean useAround();

    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    public void after();

    public void afterReturning();

    public void afterThrowing();
}
