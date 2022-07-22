package org.wys.demo.test.transactional;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author wys
 * @date 2022/2/8
 */
public class TransactionalTest {

    @Test
    public void testArray() {
        PaymentRequest request = new PaymentRequest();
        request.setPayer("我");
        request.setBeneficiary("你");
        request.setAmount(new BigDecimal(2000L));
        TransferService.transferMoney(request);
    }

    public void print(Object obj) {

        System.out.println(obj.toString());
    }

}
