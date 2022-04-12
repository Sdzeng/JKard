package com.jkard.jkexperiment.service.impl;

import com.jkard.jkexperiment.service.IParentTestService;
import org.springframework.stereotype.Service;

@Service
public class ParentTestServiceImpl implements IParentTestService {
    @Override
    public boolean validate() {
        return true;
    }
}
