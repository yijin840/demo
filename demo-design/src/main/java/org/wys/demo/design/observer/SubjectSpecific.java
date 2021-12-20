package org.wys.demo.design.observer;

/**
 * @author wys
 * @date 2021/7/7 11:06 上午
 */
public class SubjectSpecific extends Subject{

    @Override
    public void change(Object obj) {
        observers.forEach(observer -> {
            observer.response((int)obj);
        });
    }

}
