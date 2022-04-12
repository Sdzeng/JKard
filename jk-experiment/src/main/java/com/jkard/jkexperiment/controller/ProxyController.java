package com.jkard.jkexperiment.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "代理")
@RestController
@RequestMapping("/proxy")
//@CrossOrigin
public class ProxyController {

//    @Autowired
//    private ITestService _testService;

    /**
     * 客户群统计-按群统计
     */
    @ApiOperation("测试代理")
    @PostMapping("/cluster")
    public String clustersStatisticsCluster() {//@RequestBody @Validated ClustersStatisticsBo bo, @RequestHeader(required = true) String token
//        ITestService proxy = (ITestService) ProxyService.getProxy(_testService, new MyInterceptor());
//        proxy.print();
        return "great";
    }
}
