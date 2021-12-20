package org.wys.demo.design.observer;

/**
 * @author wys
 * @date 2021/7/7 11:20 上午
 */
public class ObserverApplication {
    public static void main(String[] args) {
        Observer o1 = new ObserverSpecific();
        Subject subject = new SubjectSpecific();
        subject.add(o1);
        subject.change(10);
    }
}
