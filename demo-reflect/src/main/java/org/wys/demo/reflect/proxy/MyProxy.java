package org.wys.demo.reflect.proxy;

import net.sf.cglib.proxy.Proxy;
import org.wys.demo.reflect.proxy.func.ProxyFunction;

/**
 * @author wys
 * @date 2022/1/6
 */
public class MyProxy {

    public static void main(String[] args) {
        ProxyFunction proxy = (ProxyFunction) Proxy.newProxyInstance(ProxyFunction.class.getClassLoader(),
                new Class[]{ProxyFunction.class},
                (o, method, objects) -> method.invoke(o, objects));
        System.out.println(proxy.getResult());
    }


}
