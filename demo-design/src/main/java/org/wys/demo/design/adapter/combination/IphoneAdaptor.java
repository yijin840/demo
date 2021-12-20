package org.wys.demo.design.adapter.combination;

import org.wys.demo.design.adapter.Android;
import org.wys.demo.design.adapter.Iphone;

/**
 * @author wys
 * @date 2021/7/20
 */
public class IphoneAdaptor implements Iphone {

    private final Android android;

    public IphoneAdaptor(Android android) {
        this.android = android;
    }

    @Override
    public void iphoneDescription() {
        android.androidDescription();
    }
}
