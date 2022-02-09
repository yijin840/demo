package org.wys.demo.test.transactional;

import lombok.Data;
import org.wys.demo.common.annotation.Field;

import java.math.BigDecimal;

/**
 * @author wys
 * @date 2022/2/9
 */
@Data
public class PaymentRequest {

    @Field(name = "付款方")
    private String payer;

    @Field(name = "收款方")
    private String beneficiary;

    @Field(name = "金额")
    private BigDecimal amount;

}
