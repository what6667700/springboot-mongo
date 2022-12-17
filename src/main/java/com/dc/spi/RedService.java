package com.dc.spi;

/**
 * Created by Administrator on 2017/8/28.
 */
public class RedService implements DubboService {
    public void sayHello() {

        System.out.println("我是RedService服务实现");

    }
}