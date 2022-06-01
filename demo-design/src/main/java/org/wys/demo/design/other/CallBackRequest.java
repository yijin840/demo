package org.wys.demo.design.other;

import lombok.Data;
import org.wys.demo.design.other.request.AbstractRequest;
import org.wys.demo.design.other.response.AbstractResponse;

/**
 * @author wys
 * @date 2022/6/1
 */
@Data
public class CallBackRequest<REQ extends AbstractRequest, RSP extends AbstractResponse> {

    private REQ request;
    private Class<RSP> rspClass;

}
