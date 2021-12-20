package org.wys.demo.http;

import lombok.Data;

/**
 * @author wys
 * @date 2021/7/23
 */
@Data
public class HttpClient {

    private final HttpRequest httpRequest;

    private final HttpResponse httpResponse;


    public HttpResponse get() {
        return null;
    }

    public HttpResponse post() {
        return null;
    }
}
