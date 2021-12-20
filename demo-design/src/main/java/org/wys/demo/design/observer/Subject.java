package org.wys.demo.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wys
 * @date 2021/7/7 11:01 上午
 */
public abstract class Subject {

    protected final List<Observer> observers = new ArrayList<>();

    public abstract void change(Object obj);

    public void add(Observer observer) {
        observers.add(observer);
    }
    public void remove(Observer observer) {
        observers.remove(observer);
    }
}
