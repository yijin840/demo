package org.wys.demo.design.other;

import org.wys.demo.design.other.response.BaseResponse;

/**
 * @author wys
 * @date 2022/6/1
 * 回调中心
 */
public class SimpleResponseCallBack implements ResponseCallBack {

    @Override
    public <T extends BaseResponse> T callback(CallBackRequest request) throws RuntimeException {
        return ServiceClient.service(request);
    }
}
