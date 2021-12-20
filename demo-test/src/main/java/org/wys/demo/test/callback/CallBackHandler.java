package org.wys.demo.test.callback;

import java.lang.reflect.Method;

/**
 * @author wys
 * @date 2021/12/14
 */
@FunctionalInterface
public interface CallBackHandler {


    /**
     * CallBack
     */
    void callBack(Method method);

}
