package org.wys.demo.design.other;

import lombok.Data;

/**
 * ClassName ButtRequest
 * Package org.wys.demo.design.other
 * Description
 *
 * @author wys
 * @date 2022/5/31 22:04
 */
@Data
public class ButtRequest extends AbstractRequest {

    private String type;

    private Long id;

}
