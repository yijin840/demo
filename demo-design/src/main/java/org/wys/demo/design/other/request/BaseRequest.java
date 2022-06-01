package org.wys.demo.design.other.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.wys.demo.design.other.response.BaseResponse;

/**
 * @author wys
 * @date 2022/6/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseRequest extends AbstractRequest {

    private static final long serialVersionUID = -2523072796559211919L;
    private Long id;
    private String keyWord;
    protected Class<BaseResponse> rspClass;
}
