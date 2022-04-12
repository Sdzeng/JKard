package com.jkard.jkexperiment.controller;

import com.jkard.jkexperiment.common.proxy.MyInterceptor;
import com.jkard.jkexperiment.service.ITestService;
import com.jkard.jkexperiment.service.impl.ProxyServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Validated
@Api(tags = "代理")
@RestController
@RequestMapping("/proxy")
//@CrossOrigin
public class ProxyController {

    @Autowired
    private ITestService _testService;

    /**
     * 测试代理
     */
    @ApiOperation("测试代理")
    @PostMapping("/testProxy")
    public String testProxy(String content) {//@RequestBody @Validated ClustersStatisticsBo bo, @RequestHeader(required = true) String token
        ITestService proxy = (ITestService) ProxyServiceImpl.getProxy(_testService, new MyInterceptor());
        proxy.print(content);
        return "great";
    }
}
