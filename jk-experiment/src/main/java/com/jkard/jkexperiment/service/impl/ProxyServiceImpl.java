package com.jkard.jkexperiment.service.impl;

import com.jkard.jkexperiment.common.proxy.Interceptor;
import com.jkard.jkexperiment.common.proxy.Invocation;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyServiceImpl implements InvocationHandler {
    private Object target = null;
    private Interceptor interceptor = null;

    public static Object getProxy(Object target, Interceptor interceptor) {
        ProxyServiceImpl proxyHelper = new ProxyServiceImpl();
        proxyHelper.target = target;
        proxyHelper.interceptor = interceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), proxyHelper);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        boolean exceptionFlag = false;
        try {
            if (this.interceptor.before()) {
                if (this.interceptor.useAround()) {
                    Invocation invocation = new Invocation(this.target, method, args);
                    result = this.interceptor.around(invocation);
                } else {
                    result = method.invoke(this.target, args);
                }
            }

        } catch (Exception e) {
            exceptionFlag = true;
        }
        this.interceptor.after();
        if (exceptionFlag) {
            result=null;
            this.interceptor.afterThrowing();
        } else {
            this.interceptor.afterReturning();
        }
        return result;
    }
}
