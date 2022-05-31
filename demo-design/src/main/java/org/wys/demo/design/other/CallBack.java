package org.wys.demo.design.other;

/**
 * ClassName CallBack
 * Package org.wys.demo.design.other
 * Description
 *
 * @author wys
 * @date 2022/5/31 22:11
 */
public interface CallBack {

    <T extends ButtResponse<T>> T callBack(AbstractRequest request);

}
