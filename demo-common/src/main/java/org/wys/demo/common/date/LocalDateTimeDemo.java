package org.wys.demo.common.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author wys
 * @date 2021/9/9
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate date = localDateTime.toLocalDate();
        System.out.println(localDateTime);
        Date d = new Date();
    }

}
