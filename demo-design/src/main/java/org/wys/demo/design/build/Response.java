package org.wys.demo.design.build;

import lombok.Data;

/**
 * @author wys
 * @date 2021/7/27
 */
@Data
public class Response {

    private String msg;

    private Object data;

    private Integer Code;

}
