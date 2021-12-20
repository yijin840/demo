package org.wys.demo.http;

import org.wys.demo.http.basic.HttpHeader;
import org.wys.demo.http.basic.HttpParam;
import lombok.Data;

import java.util.List;

/**
 * @author wys
 * @date 2021/7/23
 */
@Data
public class HttpRequest {

    private final List<HttpHeader> httpHeaders;
    private final List<HttpParam> httpParams;


}
