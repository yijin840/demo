package org.wys.demo.design.adapter.inherit;

import org.wys.demo.design.adapter.Android;
import org.wys.demo.design.adapter.Iphone;

/**
 *
 * @author wys
 * @date 2020/11/11 3:32 下午
 */
public class IphoneAdaptor extends Android implements Iphone {
    @Override
    public void iphoneDescription() {
        androidDescription();
    }
}
