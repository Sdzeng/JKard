package com.jkard.jkexperiment.controller;

import com.jkard.jkexperiment.common.aspect.MyAspect;
import com.jkard.jkexperiment.service.IParentTestService;
import com.jkard.jkexperiment.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@Api(tags = "Aop")
@RestController
@RequestMapping("/aspect")
//@CrossOrigin
public class AspectController {

//     使用MyAspect类中加上@Component就可以，不用@Bean
//    // 定义切面（使用注解@Bean注入到Spring IOC）
//    @Bean(name="myAspect")
//    public MyAspect initMyAspect() {
//        return new MyAspect();
//    }
//

    @Autowired
    private ITestService _testService;

    /**
     * 测试Aop
     */
    @ApiOperation("测试Aop")
    @PostMapping("/testAspect")
    public String testAspect(@Validated String content) {//@RequestBody @Validated ClustersStatisticsBo bo, @RequestHeader(required = true) String token
        _testService.aspectPrint(content);

        return "Done";
    }


    /**
     * 测试Aop引入
     */
    @ApiOperation("测试Aop引入")
    @PostMapping("/testAspectParent")
    public String testAspectParent(@Validated String content) {//@RequestBody @Validated ClustersStatisticsBo bo, @RequestHeader(required = true) String token

        //测试引入
        IParentTestService parentTestService = (IParentTestService) _testService;
        if (parentTestService.validate()) {
            _testService.aspectPrint(content);
        }
        return "Done";
    }

}
