package org.wys.demo.test.quote;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wys
 * @date 2021/9/10
 */
@Slf4j
public class QuoteDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        log.info("un modify arr ==> {}", arr);
        modifyArr(arr);
        log.info("modify arr ===> {}", arr);

        String s = "123";
        s = s.intern();
        modifyStr(s);
        log.info("modify str ==> {}", s);

        ObjClass objClass = new ObjClass();
        log.info("un modify obj ===> {}", objClass);
        modifyClassVariable(objClass);
        log.info("modify obj ==> {}", objClass);
    }

    private static void modifyClassVariable(ObjClass objClass) {
        objClass.b = 2;
    }

    private static void modifyArr(int[] arr) {
        arr[2] = 1;
    }
    private static void modifyStr(String s) {
        s = s.intern();
        s = "233";
    }


    @ToString
    static class ObjClass {
        
        int a = 0;
        int b = 1;

    }

}
