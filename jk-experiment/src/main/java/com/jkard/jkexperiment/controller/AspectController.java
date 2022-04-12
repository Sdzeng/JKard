package com.jkard.jkexperiment.controller;

import com.jkard.jkexperiment.service.IParentTestService;
import com.jkard.jkexperiment.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Validated
@Api(tags = "Aop")
@RestController
@RequestMapping("/aspect")
//@CrossOrigin
public class AspectController {


    @Autowired
    private ITestService _testService;

    /**
     * 测试Aop
     */
    @ApiOperation("测试Aop")
    @PostMapping("/testAspect")
    public String testAspect(String content) {//@RequestBody @Validated ClustersStatisticsBo bo, @RequestHeader(required = true) String token
        _testService.print(content);

        return "Done";
    }


    /**
     * 测试Aop引入
     */
    @ApiOperation("测试Aop引入")
    @PostMapping("/testAspectParent")
    public String testAspectParent(String content) {//@RequestBody @Validated ClustersStatisticsBo bo, @RequestHeader(required = true) String token

        //测试引入
        IParentTestService parentTestService = (IParentTestService) _testService;
        if (parentTestService.validate()) {
            _testService.print(content);
        }
        return "Done";
    }

}
