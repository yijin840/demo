package org.wys.demo.http.basic;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wys
 * @date 2021/7/23
 */
@Data
public class HttpHeader implements Serializable{

    private static final long serialVersionUID = -3580302623915804781L;
    private String key;
    private String value;

    public HttpHeader(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
