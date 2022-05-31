package org.wys.demo.design.other;

import com.alibaba.fastjson.JSON;

/**
 * ClassName ExcuteFunction
 * Package org.wys.demo.design.other
 * Description
 *
 * @author wys
 * @date 2022/5/31 22:27
 */
public class ExecuteFunction {

    public static <T extends ButtResponse<T>> T request(AbstractRequest request) {
        ButtRequest buttRequest;
        if (request instanceof ButtRequest) {
            buttRequest = (ButtRequest) request;
            ButtResponse<T> buttResponse = new ButtResponse<>();
            buttResponse.setMessage("OK");
            return (T)request(JSON.toJSONString(buttResponse), ButtResponse.class);
        }
        return null;
    }

    private static <T extends ButtResponse<T>> T request(String entity, Class<T> tClass) {
        T res = JSON.parseObject(entity, tClass);
        res.setContent(res);
        return res;
    }

}
