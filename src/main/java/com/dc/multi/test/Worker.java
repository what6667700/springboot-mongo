package com.dc.multi.test;

import java.util.concurrent.ThreadFactory;

public class Worker implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
