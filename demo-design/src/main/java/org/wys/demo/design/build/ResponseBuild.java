package org.wys.demo.design.build;

/**
 * @author wys
 * @date 2021/7/27
 */
public class ResponseBuild {

    private final Response response;

    public ResponseBuild() {
        response = new Response();
    }
    public ResponseBuild buildMsg(String msg) {
        response.setMsg(msg);
        return this;
    }
    public ResponseBuild buildCode(Integer code) {
        response.setCode(code);
        return this;
    }
    public ResponseBuild buildData(Object data) {
        response.setData(data);
        return this;
    }

    public Response get() {
        return this.response;
    }
}
