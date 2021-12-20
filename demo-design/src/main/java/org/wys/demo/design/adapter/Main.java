package org.wys.demo.design.adapter;


import org.wys.demo.design.adapter.combination.IphoneAdaptor;

/**
 * @author wys
 * @date 2020/11/11 3:35 下午
 */
public class Main {
    public static void main(String[] args) {

        Iphone iphone =  new IphoneAdaptor(new Android());
        iphone.iphoneDescription();
    }
}
