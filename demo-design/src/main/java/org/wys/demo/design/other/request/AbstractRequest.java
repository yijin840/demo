package org.wys.demo.design.other.request;

import org.wys.demo.design.other.response.BaseResponse;

import java.io.Serializable;

/**
 * ClassName AbstractRequest
 * Package org.wys.demo.design.other
 * Description
 *
 * @author wys
 * @date 2022/5/31 22:03
 * 通用父类
 */
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 4683641068490145846L;
    public final String version = "1.0";

}
