package com.jkard.jkexperiment.service.impl;


import com.jkard.jkexperiment.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void proxyPrint() {
        System.out.println("哈哈哈");
    }

    @Override
    public void aspectPrint(String content) {
        System.out.println(content);
    }
}
