package org.wys.demo.design.other;

/**
 * ClassName ClientTest
 * Package org.wys.demo.design.other
 * Description
 *
 * @author wys
 * @date 2022/5/31 21:55
 */
public class ClientTest {

    public static void main(String[] args) {
        //Client
        ButtCallBack buttCallBack = new ButtCallBack();
        //request
        ButtRequest request = new ButtRequest();
        request.setId(1L);
        request.setType("TEST");
        //response
        Object response = buttCallBack.callBack(request);
        //Model
        System.out.println(response);
    }

}
