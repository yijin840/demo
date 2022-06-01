package org.wys.demo.design.other;

import org.wys.demo.design.other.request.BaseRequest;
import org.wys.demo.design.other.response.BaseResponse;
import org.wys.demo.design.other.response.SimpleResponse;

/**
 * @author wys
 * @date 2022/6/1
 */
public class CallBackTest {

    public static void main(String[] args) {
        //request
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setId(1L);
        baseRequest.setKeyWord("test");
        CallBackRequest<BaseRequest, BaseResponse> request = new CallBackRequest<>();
        //response
        SimpleResponseCallBack simpleResponseCallBack = new SimpleResponseCallBack();
        request.setRspClass(BaseResponse.class);
        request.setRequest(baseRequest);
        BaseResponse callback = simpleResponseCallBack.callback(request);
        System.out.println(callback);
    }

}
