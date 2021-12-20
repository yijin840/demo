package org.wys.demo.spring.aop.test;

import com.google.common.base.Throwables;
import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2021/7/28
 */
@Component
public class ApiTest {

    public void transfer(String args) {
//        new Futur
    }

    public static void main(String[] args) {

        try{
            int a = 1/0;
        }catch (Exception e) {
            System.out.println(Throwables.getRootCause(e));
        }
    }

}
