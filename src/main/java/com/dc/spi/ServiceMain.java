package com.dc.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceMain {

    public static void main(String[] args) {

        ServiceLoader<DubboService> spiLoader = ServiceLoader.load(DubboService.class);
        Iterator<DubboService> iterableSpi = spiLoader.iterator();
        while (iterableSpi.hasNext()){
            DubboService dubboService = iterableSpi.next();
            dubboService.sayHello();
        }
    }
}


//public class ServiceMain {
//
//    public  static void main(String[] args){
//
//        ServiceLoader<DubboService> spiLoader = ServiceLoader.load(DubboService.class);
//        Iterator<DubboService>  iteratorSpi=spiLoader.iterator();
//        while (iteratorSpi.hasNext()){
//            DubboService dubboService=iteratorSpi.next();
//            dubboService.sayHello();
//        }
//
//    }
//}