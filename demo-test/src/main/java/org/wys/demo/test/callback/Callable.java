package org.wys.demo.test.callback;

/**
 * @author wys
 * @date 2021/12/14
 */
@FunctionalInterface
public interface Callable<V> {

    V call();

}
