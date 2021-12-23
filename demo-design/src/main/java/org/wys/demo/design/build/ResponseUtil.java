package org.wys.demo.design.build;

/**
 * @author wys
 * @date 2021/7/27
 */
public class ResponseUtil {

    public static Response success(Object data) {
        return new ResponseBuild().buildData(data).buildCode(200).buildMsg(ResponseCode.getByCode(200).getMsg()).build();
    }

    public static Response fail(String msg, Integer code) {
        return new ResponseBuild().buildData(null).buildMsg(msg).buildCode(code).build();
    }

    public static Response fail(Integer code) {
        return new ResponseBuild().buildData(null).buildCode(code).buildMsg(ResponseCode.getByCode(code).getMsg()).build();
    }

    public static Response fail(Integer code, String msg) {
        return new ResponseBuild().buildData(null).buildCode(code).buildMsg(ResponseCode.getByCode(code).getMsg()).build();
    }
}
