package org.wys.demo.test;

import org.wys.demo.test.callback.CallBackHandler;
import org.wys.demo.test.callback.Callable;
import org.wys.demo.test.callback.FutureTask;

import java.lang.reflect.Method;

/**
 * @author wys
 * @date 2021/12/14
 */
public class CallBackTest {

    public static void main(String[] args) {
//        doWithMethod(1, method -> {
//            System.out.println(method.getName());
//        });

        FutureTask<Integer> futureTask = new FutureTask<>();
        Integer num = futureTask.doWithTask(() -> {
            int sum = 0;
            for(int i=0;i<100;i++) {
                sum += i;
            }
            return sum;
        });
        System.out.println(num);

    }

    public static void doWithMethod(int a, CallBackHandler callBack) {
        System.out.println(a);
        CallBackTest callBackTest = new CallBackTest();
        Method[] declaredMethods = callBackTest.getClass().getDeclaredMethods();
        for(Method mc : declaredMethods) {
            callBack.callBack(mc);
        }
    }

    public void test() {
        System.out.println("test");
    }

}
