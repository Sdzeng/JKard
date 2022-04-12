package com.jkard.jkexperiment.service.impl;


import com.jkard.jkexperiment.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITestService {
    @Override
    public void print(String content) {
        System.out.println(content);
    }
}
