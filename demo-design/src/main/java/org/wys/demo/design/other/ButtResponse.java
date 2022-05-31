package org.wys.demo.design.other;

import lombok.Data;

/**
 * ClassName ButtResponse
 * Package org.wys.demo.design.other
 * Description
 *
 * @author wys
 * @date 2022/5/31 22:09
 */
@Data
public class ButtResponse<T> implements AbstractResponse<T> {
    private T content;
    private String message;

}
