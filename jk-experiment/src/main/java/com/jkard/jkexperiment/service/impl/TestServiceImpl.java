package com.jkard.jkexperiment.service.impl;


import com.jkard.jkexperiment.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void print() {
        System.out.println("哈哈哈");
    }
}
