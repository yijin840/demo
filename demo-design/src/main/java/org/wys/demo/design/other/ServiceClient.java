package org.wys.demo.design.other;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.wys.demo.design.other.request.BaseRequest;
import org.wys.demo.design.other.response.AbstractResponse;
import org.wys.demo.design.other.response.BaseResponse;
import org.wys.demo.design.other.response.SimpleResponse;

/**
 * @author wys
 * @date 2022/6/1
 */
public class ServiceClient {

    public static <T extends BaseResponse> T service(CallBackRequest request) {
        request.setRspClass(BaseResponse.class);
        //String post = HttpUtil.post("localhost:8080/123", JSON.toJSONString(request));
        String post = "";
        BaseResponse baseResponse = new SimpleResponse();
        baseResponse.setRequest(request.getRequest());
        baseResponse.setContent(new Object());
        post = JSON.toJSONString(baseResponse);
        return (T) service(post, request.getRspClass());
    }

    public static <T extends BaseResponse> T service(String entity, Class<T> resClass) {
        if (StringUtils.isBlank(entity)) {
            return null;
        }
        return JSON.parseObject(entity, resClass);
    }

}
