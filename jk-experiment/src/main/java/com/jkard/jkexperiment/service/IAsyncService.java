package com.jkard.jkexperiment.service;

import java.util.concurrent.CountDownLatch;

public interface IAsyncService {
    public void Run();

    public void Run2(CountDownLatch latch);
}
