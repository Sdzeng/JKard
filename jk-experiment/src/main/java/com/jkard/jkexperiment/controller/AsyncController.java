package com.jkard.jkexperiment.controller;

import com.jkard.jkexperiment.service.IAsyncService;
import com.jkard.jkexperiment.service.impl.AsyncService;
import io.swagger.annotations.Api;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.CountDownLatch;

@Api(tags = "异步")
@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private IAsyncService _asyncService;

    @GetMapping("/print_thread")
    public String printThread() {
        _asyncService.Run();
        System.out.println("线程:" + Thread.currentThread().getName());
        return "done";
    }

    @GetMapping("/print_thread2")
    public String printThread2() throws InterruptedException {
        CountDownLatch latch=new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            _asyncService.Run2(latch);
        }
        latch.await();
        System.out.println("线程:" + Thread.currentThread().getName());
        return "done";
    }
}
