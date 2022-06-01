package org.wys.demo.design.other;

import org.wys.demo.design.other.request.AbstractRequest;
import org.wys.demo.design.other.request.BaseRequest;
import org.wys.demo.design.other.response.AbstractResponse;
import org.wys.demo.design.other.response.BaseResponse;

/**
 * @author wys
 * @date 2022/6/1
 */
public interface ResponseCallBack {

    /**
     * 响应回调接口
     *
     * @param <T>     类型
     * @param request 请求
     * @return 回调
     * @throws RuntimeException 运行时异常
     */
    <T extends BaseResponse> T callback(CallBackRequest<? extends BaseRequest, ? extends BaseResponse> request) throws RuntimeException;

}
