package org.wys.demo.design.other.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.wys.demo.design.other.request.AbstractRequest;

/**
 * @author wys
 * @date 2022/6/1
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BaseResponse extends AbstractResponse {

    private static final long serialVersionUID = -8008765026994891245L;
    protected Object content;
    protected AbstractRequest request;
}
