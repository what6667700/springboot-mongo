package com.dc.multi;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

@Configuration
public class ThreadPoolConfig {

    @Bean(value = "threadPoolInstance")
    public ExecutorService createThreadPoolInstance(){
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,16,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(100),
                threadFactory,new ThreadPoolExecutor.AbortPolicy());
        return threadPoolExecutor;
    }

}
