package com.jkard.jkexperiment.service.impl;

import com.jkard.jkexperiment.service.IAsyncService;
import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class AsyncService implements IAsyncService {
    @Override
    @Async
    public void Run() {
        System.out.println("线程：" + Thread.currentThread().getName());
    }


    @Override
    @Async
    @SneakyThrows
    public void Run2(CountDownLatch latch) {
        System.out.println("线程：" + Thread.currentThread().getName());
        Thread.sleep(5000L);
        latch.countDown();
    }
}
