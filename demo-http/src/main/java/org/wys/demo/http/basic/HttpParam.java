package org.wys.demo.http.basic;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wys
 * @date 2021/7/23
 */
@Data
public class HttpParam implements Serializable {

    private static final long serialVersionUID = 4581233624817721369L;
    private String key;
    private String value;

    public HttpParam(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
