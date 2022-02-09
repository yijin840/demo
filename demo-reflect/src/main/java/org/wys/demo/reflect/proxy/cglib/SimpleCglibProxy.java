package org.wys.demo.reflect.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.wys.demo.reflect.proxy.func.ProxyFunction;

import java.lang.reflect.Method;

/**
 * @author wys
 * @date 2022/2/9
 */
public class SimpleCglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyFunction.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println(methodProxy.getSuperIndex());
            return null;
        });
        ProxyFunction proxyFunction = (ProxyFunction) enhancer.create();
        System.out.println(proxyFunction.getResult());
    }

}
