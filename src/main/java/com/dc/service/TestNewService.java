package com.dc.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;


@Service
public class TestNewService {

    //通过name=threadPoolInstance引用线程池实例
    @Resource(name = "threadPoolInstance")
    private ExecutorService executorService;

    public void spikeConsumer() {
        //TODO
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                //TODO
            }});
    }
}
