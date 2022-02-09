package org.wys.demo.test.transactional;

import java.math.BigDecimal;

/**
 * @author wys
 * @date 2022/2/8
 */
public class TransferService {

    public static void transferMoney(PaymentRequest request) {
        /*
            所有的过程抽象出来，所对应的结果就是事务
            ACID
            1、原子性
            2、隔离性
            3、持久性
            4、一致性
         */
        //原子性
        String process = request.getPayer() + "给" + request.getBeneficiary() + "转账" + request.getAmount() + "元";
        String result = result(process);
        System.out.println(result);
    }

    private static String result(String process) {
        try{
            return process + "成功";
        }catch (Exception e) {
            return process + "失败";
        }
    }

}
