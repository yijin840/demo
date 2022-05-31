package org.wys.demo.design.other;

import com.alibaba.fastjson.JSON;

/**
 * ClassName ButtCallBack
 * Package org.wys.demo.design.other
 * Description
 *
 * @author wys
 * @date 2022/5/31 22:10
 */
public class ButtCallBack implements CallBack {

    @Override
    public <T extends ButtResponse<T>> T callBack(AbstractRequest request) {
        return ExecuteFunction.request(request);
    }
}
